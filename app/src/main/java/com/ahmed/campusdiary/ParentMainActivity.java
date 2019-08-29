package com.ahmed.campusdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ParentMainActivity extends AppCompatActivity {
    LinearLayout diary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_main);
        initialization();
        clicklisteners();
    }

    private void initialization() {
        diary = findViewById(R.id.diary);

    }

    private void clicklisteners() {
        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diaryActivity();
            }
        });
    }

    private void diaryActivity() {
        Intent intent = new Intent(ParentMainActivity.this,DiaryActivity.class);
        startActivity(intent);

    }

}
