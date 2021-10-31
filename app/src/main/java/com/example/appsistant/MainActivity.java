package com.example.appsistant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
        Button message_btn = findViewById(R.id.message_btn);

        message_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSmsApp();
            }
        });

        calendar_Btn.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Calendar");

            Intent intent = new Intent(Intent.ACTION_EDIT);
            intent.setType("vnd.android.cursor.item/event");
            intent.putExtra("title", "Some title");
            intent.putExtra("description", "Some description");
            intent.putExtra("beginTime", 0);
            intent.putExtra("endTime", 0);
            startActivity(intent);
        });

        cameraButton.setOnClickListener(v -> {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(intent);
        });

        Button galleryButton = findViewById(R.id.gallery_btn);

        galleryButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                    "content://media/internal/images/media"));
            startActivity(intent);
        });
    }

    public void settingsClicked(View view) {
        Button settings = findViewById(R.id.settings_btn);
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    private void openSmsApp() {
        String packageName = Telephony.Sms.getDefaultSmsPackage(MainActivity.this);
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);

        startActivity(launchIntent);//null pointer check in case package name was not found

    }
}