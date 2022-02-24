package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultima);

        videoView = findViewById(R.id.videoView);

        videoView.setMediaController(new MediaController(this) );
        videoView.setVideoPath("android.resource:" + getPackageName() + "/" + R.raw.nft);
        videoView.start();

    }
}