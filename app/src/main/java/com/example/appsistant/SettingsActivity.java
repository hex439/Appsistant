package com.example.appsistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button applyBtn = findViewById(R.id.apply_button);
        applyBtn.setOnClickListener(v -> openChangedActivity());
    }

    private void openChangedActivity() {
        Intent intent = new Intent(SettingsActivity.this, ChangedActivity.class);
        startActivity(intent);

    }
}