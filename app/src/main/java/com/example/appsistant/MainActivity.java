package com.example.appsistant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.provider.MediaStore;
import android.view.View;
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
        Button calendar_Btn = findViewById(R.id.calendarBtn);
        Button cameraButton = findViewById(R.id.cameraBtn);

        calendar_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Calendar");

                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("title", "Some title");
                intent.putExtra("description", "Some description");
                intent.putExtra("beginTime", 0);
                intent.putExtra("endTime", 0);
                startActivity(intent);
            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
    }
}