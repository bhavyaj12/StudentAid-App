package com.example.collegeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class BooksPortal extends AppCompatActivity {

    private DatabaseReference mDatabase;
    ListView listView;
    FirebaseDatabase database;
    Button btnAddNew;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User2 user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksportal);

        btnAddNew = findViewById(R.id.button7);
        user2= new User2();
        listView = (ListView) findViewById(R.id.listview);
        database = FirebaseDatabase.getInstance();
        ref= database.getReference("books");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.userinfo,R.id.userinfo,list);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                adapter.notifyDataSetChanged();
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    user2=ds.getValue(User2.class);
                    list.add(user2.getBookName().toString()+" - "+user2.getAuthor().toString()+"\n"+user2.getBranch().toString()+"\n"+
                            user2.getStudentName().toString()+", "+user2.getContact().toString());
                }
                listView.setAdapter(adapter);

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToAddNew = new Intent(BooksPortal.this, addNew.class);
                startActivity(intToAddNew);
            }
        });





    }
}
