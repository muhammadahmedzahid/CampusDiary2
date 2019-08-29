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

public class MainActivity extends AppCompatActivity {

    Button loginParents;
    MaterialButton campusLogin;
    ProgressBar progressBarParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickMethods();

    }


    private void loginparentMainActivity() {
        Intent intent = new Intent(MainActivity.this,ParentMainActivity.class);
        startActivity(intent);
        finish();
    }

    private void clickMethods() {
        loginParents = findViewById(R.id.loginParents);
        campusLogin = findViewById(R.id.campusLogin);
        progressBarParent = findViewById(R.id.progressBarParent);

        campusLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                campusActivity();
            }
        });
        loginParents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBarParent.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loginparentMainActivity();
                    }
                },2000);

            }
        });


    }


    private void campusActivity() {
        Intent intent = new Intent(MainActivity.this,CampusLogin.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }

}
