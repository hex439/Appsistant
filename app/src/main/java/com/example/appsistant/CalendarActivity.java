package com.example.appsistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        ImageButton viewCalendar = findViewById(R.id.view_calendar);
        ImageButton createEvent = findViewById(R.id.create_event);

        viewCalendar.setOnClickListener(view -> {
            Log.d(TAG, "onClick: View Calendar Button");
            Log.d("CalendarActivity", "Launched: calendarFragment");

            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("title", "Some title");
            intent.putExtra("description", "Some description");
            intent.putExtra("beginTime", 0);
            intent.putExtra("endTime", 0);
            startActivity(intent);

        });

    }

    public void createEventClicked(View view) {
        Log.d(TAG, "onClick: Create Event Button");

        Calendar calendarEvent = Calendar.getInstance();
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", true);
        i.putExtra("rule", "FREQ=YEARLY");
        i.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
        i.putExtra("title", "Calendar Event");
        startActivity(i);
        }

}
