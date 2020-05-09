package com.example.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addNew extends AppCompatActivity {
    Button btnSubmit;
    EditText book,student,author,branch,contact;
    FirebaseDatabase database;
    DatabaseReference ref;
    User2 bk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        book = (EditText) findViewById(R.id.editText3);
        student = (EditText) findViewById(R.id.editText);
        author = (EditText) findViewById(R.id.editText4);
        branch = (EditText) findViewById(R.id.editText7);
        contact = (EditText) findViewById(R.id.editText2);
        btnSubmit = findViewById(R.id.button);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("books");
        bk = new User2();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (book.length() == 0) {
                    book.setError("Enter");
                } else if (student.length() == 0) {
                    student.setError("Enter");
                } else if (author.length() == 0) {
                    author.setError("Enter");
                } else if (branch.length() == 0) {
                    branch.setError("Enter");
                } else if (contact.length() == 0) {
                    contact.setError("Enter");
                } else {

                    bk.setBookName(book.getText().toString());
                    bk.setStudentName(student.getText().toString());
                    bk.setAuthor(author.getText().toString());
                    bk.setBranch(branch.getText().toString());
                    Long ph = Long.parseLong(contact.getText().toString());
                    bk.setContact(ph);
                    String v1 = book.getText().toString();
                    String v2 = student.getText().toString();
                    String v3 = author.getText().toString();
                    String v4 = branch.getText().toString();
                    String v5 = contact.getText().toString();

                    ref.push().setValue(bk);
                    Toast.makeText(addNew.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                    Intent intToAddNew = new Intent(addNew.this, HomeActivity.class);
                    startActivity(intToAddNew);
                }


            }
        });

        }
}
