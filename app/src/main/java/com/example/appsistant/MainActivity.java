package com.example.appsistant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

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




    }
}