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
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private int fontSize = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clock = findViewById(R.id.button_clock);
        Button calendar_Btn = findViewById(R.id.calendarBtn);
        Button cameraButton = findViewById(R.id.cameraBtn);
        Button message_btn = findViewById(R.id.message_btn);
        Button contacts = findViewById(R.id.button_contacts);
        Button galleryButton = findViewById(R.id.gallery_btn);
        Button increaseFontButton = findViewById(R.id.increase_button);
        Button decreaseFontButton = findViewById(R.id.decrease_button);
        Button settings = findViewById(R.id.settings_btn);
        Button tutorialButton = findViewById(R.id.tutorial_button);

        clock.setOnClickListener(v -> {
            Intent intent= new Intent(AlarmClock.ACTION_SHOW_ALARMS);
            startActivity(intent);
        });

//        contacts.setOnClickListener(v -> {
//            Intent intent= new Intent(Intent.ACTION_PICK,  ContactsContract.Contacts.CONTENT_URI);
//            startActivityForResult(intent, 1);
//        });


        message_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSmsApp();
            }
        });


        cameraButton.setOnClickListener(v -> {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivity(intent);
        });


        galleryButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                    "content://media/internal/images/media"));
            startActivity(intent);
        });


        increaseFontButton.setOnClickListener(view -> {
            Log.d(TAG, "onClick: increase font size");
            fontSize ++;

            calendar_Btn.setTextSize(fontSize);
            cameraButton.setTextSize(fontSize);
            clock.setTextSize(fontSize);
            contacts.setTextSize(fontSize);
            message_btn.setTextSize(fontSize);
            galleryButton.setTextSize(fontSize);
            decreaseFontButton.setTextSize(fontSize);
            increaseFontButton.setTextSize(fontSize);
            tutorialButton.setTextSize(fontSize);
            settings.setTextSize(fontSize);

        });

        decreaseFontButton.setOnClickListener(view -> {
            Log.d(TAG, "onClick: decrease font size");
            fontSize --;

            calendar_Btn.setTextSize(fontSize);
            cameraButton.setTextSize(fontSize);
            clock.setTextSize(fontSize);
            contacts.setTextSize(fontSize);
            message_btn.setTextSize(fontSize);
            galleryButton.setTextSize(fontSize);
            decreaseFontButton.setTextSize(fontSize);
            increaseFontButton.setTextSize(fontSize);
            tutorialButton.setTextSize(fontSize);
            settings.setTextSize(fontSize);
        });

        tutorialButton.setOnClickListener(v -> {
            Log.d(TAG, "onClick: tutorial");

        });
    }

    public void settingsClicked(View view) {
        Log.d(TAG, "onClick: Settings Button");

        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void calendarClicked(View view) {
        Log.d(TAG, "onClick: Calendar Button");

        Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
        startActivity(intent);
    }

    public void contactsClicked(View view) {
        Log.d(TAG, "onClick: Contact Button");

        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
        startActivity(intent);
    }


    private void openSmsApp() {
        String packageName = Telephony.Sms.getDefaultSmsPackage(MainActivity.this);
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);

        startActivity(launchIntent);//null pointer check in case package name was not found

    }

}