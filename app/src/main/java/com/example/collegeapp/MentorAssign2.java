package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.widget.EditText;

public class MentorAssign2 extends AppCompatActivity {
    EditText mass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_assign2);
        mass = (EditText) findViewById(R.id.editText13);
        String[] arr={"Name:Neha, Phone: 8746758975", "Name: Arshiya, Phone: 8297508956", "Name: Ria, Phone: 6578695674", "Name: Amit, Phone: 9678598709", "Name: Kartik,Phone: 7869859879"};
        Random r=new Random();
        int randomNumber=r.nextInt(arr.length);
        mass.append(arr[randomNumber]);
    }
}
