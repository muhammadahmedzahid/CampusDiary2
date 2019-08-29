package com.ahmed.campusdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FacultyActivity extends AppCompatActivity {
    Toolbar toolbar;
    LinearLayout linearLayout;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        toolbar = findViewById(R.id.toolbar);
        linearLayout = findViewById(R.id.specificDiary);
        fab = findViewById(R.id.floating_action_button);
        toolbar.setTitle("Diary");
        setSupportActionBar(toolbar);
        clicklisteners();
    }

    private void clicklisteners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyActivity.this,AddingDiaryView.class);
                startActivity(intent);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FacultyActivity.this,activity_teacher_diary_opening.class);
                startActivity(intent);
            }
        });
    }


}
