package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MentorHome extends AppCompatActivity {
    Button btnMent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_home);
        btnMent=findViewById(R.id.button5);

        btnMent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToMentor = new Intent(MentorHome.this, MentorAssign2.class);
                startActivity(intToMentor);
            }
        });
    }
}
