package com.ahmed.campusdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.style.CharacterStyle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class AddingDiaryView extends AppCompatActivity {
    private Toolbar diaryEditToolbar;
    private TextInputLayout diaryTitle;
    private Button saveDiary;
    private TextView chooseDate,chooseTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_diary_view);
        diaryEditToolbar = findViewById(R.id.diaryEditToolbar);
        diaryTitle = findViewById(R.id.diaryTitle1);
        saveDiary = findViewById(R.id.saveDiary);
        chooseDate = findViewById(R.id.chooseDate);
        chooseTime = findViewById(R.id.chooseTime);
        diaryEditToolbar.setTitle("Add New Diary");
        setSupportActionBar(diaryEditToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        clicklisteners();
    }
    private  void handleDateButton()
    {
         final Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);
          DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                String datastring = date +"-" + month +"-"+ year;
            chooseDate.setText(datastring);

            Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR,year);
                calendar1.set(Calendar.MONTH,month);
                calendar1.set(Calendar.DATE,date);

                CharSequence dateCharSequence = DateFormat.format("EEEE dd MMM yyy",calendar1);
                chooseDate.setText(dateCharSequence);
            }
        },YEAR,MONTH,DATE);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        datePickerDialog.show();
    }
    private  void handleTimeButton()
    {


        final Calendar calendar = Calendar.getInstance();
       int HOUR = calendar.get(Calendar.HOUR);
       int MINUTE = calendar.get(Calendar.MINUTE);
    TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            String AM_PM = " AM";
            String mm_precede = "";
            if (hourOfDay >= 12) {
                AM_PM = " PM";
                if (hourOfDay >=13 && hourOfDay < 24) {
                    hourOfDay -= 12;
                }
                else {
                    hourOfDay = 12;
                }
            } else if (hourOfDay == 0) {
                hourOfDay = 12;
            }
            if (minute < 10)
                mm_precede = "0";
        chooseTime.setText(  "" + hourOfDay + ":" + mm_precede + minute + AM_PM );
        }
    },HOUR,MINUTE,false);

        timePickerDialog.show();
    }


    private void clicklisteners() {

        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleDateButton();
            }
        });
        chooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleTimeButton();
            }
        });





        saveDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingDiary();

            }
        });
    }

    private Boolean settingDiary(){
        String diarytitle = diaryTitle.getEditText().getText().toString();
        if(diarytitle.isEmpty())
        {
            diaryTitle.setError("Please write the Title");
            return false;
        }
        else
        {
            diaryTitle.setError(null);
            diaryTitle.setErrorEnabled(false);
            return true;
        }
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
