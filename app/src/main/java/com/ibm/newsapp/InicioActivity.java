package com.ibm.newsapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.ibm.newsapp.api.ApiController;


public class InicioActivity extends AppCompatActivity {

    float x1, x2, y1, y2;
    ApiController api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telainicio);
        colorBar();

        ApiController.fetchAllData();

        ImageView imageView = findViewById(R.id.gif);

        Glide.with(this)
                .asGif()
                .load(R.raw.subway)
                .into(imageView);
    }

    protected void colorBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if(x1 < x2){
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
        }
        return false;
    }


}
