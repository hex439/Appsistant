package com.example.appsistant;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ContactsActivity extends AppCompatActivity {

    private static final String TAG = "ContactsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ImageButton viewContact = findViewById(R.id.view_contacts);
        ImageButton callContact = findViewById(R.id.call_contact);
        ImageButton addContact = findViewById(R.id.add_contact);


        viewContact.setOnClickListener(view -> {
            Log.d(TAG, "onClick: View Contacts Button");

            Intent i = new Intent();
            i.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.DialtactsContactsEntryActivity"));
            i.setAction("android.intent.action.MAIN");
            i.addCategory("android.intent.category.LAUNCHER");
            i.addCategory("android.intent.category.DEFAULT");
            startActivity(i);

        });

        callContact.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Call Contacts Button");

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:1234567"));
            startActivity(intent);

        });

        addContact.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Add Contacts Button");

            Intent i = new Intent();
            i.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.DialtactsContactsEntryActivity"));
            i.setAction("android.intent.action.MAIN");
            i.addCategory("android.intent.category.LAUNCHER");
            i.addCategory("android.intent.category.DEFAULT");
            startActivity(i);

        });
    }
}
