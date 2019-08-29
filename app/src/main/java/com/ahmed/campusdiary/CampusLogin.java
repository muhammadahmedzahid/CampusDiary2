package com.ahmed.campusdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class CampusLogin extends AppCompatActivity {
    MaterialButton parentActivity;
    Button login;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_login);
        initialization();
        listeners();
    }


    private void listeners() {
        parentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campusActivity();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(CampusLogin.this,FacultyActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },3000);


            }
        });
    }


    private void initialization() {
        parentActivity = findViewById(R.id.parentLogin);
        login = findViewById(R.id.loginParents);
        progressBar = findViewById(R.id.progressBarCampus);
    }
    void campusActivity()
    {
        Intent intent = new Intent(CampusLogin.this,MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        finish();
    }


}
