package com.ahmed.campusdiary;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DiaryActivity extends AppCompatActivity {
    private TextView diaryTitle,diaryDescription,diaryDate,diaryTime;
    String diarytitle, diarydescription,diarydate,diarytime;
    Toolbar toolbar;
    LinearLayout specificDiary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        initialization();
        toolbar.setTitle("Diary");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        clicklisteners();
        getvales();

    }

    private void clicklisteners() {
        specificDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diaryActivity();

            }
        });
    }

    private void getvales() {
        diarytitle = diaryTitle.getText().toString();
        diarydescription = diaryDescription.getText().toString();
        diarydate = diaryDate.getText().toString();
        diarytime = diaryTime.getText().toString();
    }

    private void initialization() {
        specificDiary = findViewById(R.id.specificDiary);
        toolbar = findViewById(R.id.toolbar);
        diaryTitle = findViewById(R.id.diaryTitle);
        diaryDescription = findViewById(R.id.diaryDescription);
        diaryDate = findViewById(R.id.dates);
        diaryTime = findViewById(R.id.time);
    }

    private void diaryActivity() {
        Intent intent = new Intent(DiaryActivity.this,DiaryOpening.class);
        intent.putExtra(diarytitle,"diarytitle");
        intent.putExtra(diarydescription,"diarydescrription");
        intent.putExtra(diarydate,"diarydate");
        intent.putExtra(diarytime,"diarytime");
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
