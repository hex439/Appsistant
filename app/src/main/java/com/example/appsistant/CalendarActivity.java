package com.example.appsistant;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

public class CalendarActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        getSupportFragmentManager().beginTransaction().add(R.id.calendar_fragment_container, new CalendarFragment()).commit();
        Log.d("CalendarActivity", "Launched: calendarFragment");
    }
}