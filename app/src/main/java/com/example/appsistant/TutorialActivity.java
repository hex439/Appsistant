package com.example.appsistant;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class TutorialActivity extends AppCompatActivity {

    Button play;
    VideoView videoView;
    MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        play = (Button) findViewById(R.id.play_button);
        videoView = (VideoView) findViewById(R.id.videoView);
        mediaC = new MediaController(this);

    }

    public void videoPlay (View v) {

        String videopath = "android.resource://com.example.appsistant/"+R.raw.movie;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaC);
        mediaC.setAnchorView(videoView);

        videoView.start();
    }


}