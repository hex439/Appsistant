package com.example.appsistant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clock = findViewById(R.id.button_clock);
        clock.setOnClickListener(v -> {
            Intent intent= new Intent(AlarmClock.ACTION_SHOW_ALARMS);
            startActivity(intent);
        });

        Button contacts = findViewById(R.id.button_contacts);
        contacts.setOnClickListener(v -> {
            Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, 1);
        });



    }
}