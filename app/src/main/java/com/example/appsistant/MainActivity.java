package com.example.appsistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout calendar = findViewById(R.id.calendar);
        calendar.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Calendar");

            Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
            startActivity(intent);
        });

        ImageButton contacts = findViewById(R.id.button_contacts);
        contacts.setOnClickListener(v -> {
            Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, 1);
        });

        ImageButton clock = findViewById(R.id.button_clock);
        clock.setOnClickListener(v -> {
            Intent intent= new Intent(AlarmClock.ACTION_SHOW_ALARMS);
            startActivity(intent);
        });






    }
}