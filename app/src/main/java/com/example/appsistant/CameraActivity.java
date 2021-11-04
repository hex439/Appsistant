package com.example.appsistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ImageView takePhotoButton = findViewById(R.id.takePhotoBtn);
        takePhotoButton.setOnClickListener(v -> photoBtnPressed());

        ImageView backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(v -> backButtonPressed());

        ImageView takeVideoButton = findViewById(R.id.takeVideoBtn);
        takeVideoButton.setOnClickListener(v -> videoBtnPressed());
    }

    private void backButtonPressed() {
        Intent intent = new Intent(CameraActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void photoBtnPressed () {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    private void videoBtnPressed () {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        startActivity(intent);
    }
}