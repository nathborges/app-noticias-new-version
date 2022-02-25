package com.ibm.newsapp;

import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telainicio);
        getSupportActionBar().hide();

        Glide.with(this)
                .load(R.raw.giphy)
                .asGif()
                .into(gif);

    }
}
