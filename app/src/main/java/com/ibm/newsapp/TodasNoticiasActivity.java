package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TodasNoticiasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_noticias);
        LinearLayout childOfScrollView = findViewById(R.id.childOfScrollView);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        CardView aleatorio = (CardView) inflater.inflate(R.layout.container, null);

        // Adicionei na ScrollView
        childOfScrollView.addView(aleatorio);
    }

    protected void changeTitle(CharSequence text, CardView cardView) {
        TextView textView = (TextView) cardView.findViewById(R.id.titleInCard);
        textView.setText(text);
    }

    protected void changeText(CharSequence text, CardView cardView) {
        TextView textView = (TextView) cardView.findViewById(R.id.textInCard);
        textView.setText(text);
    }

    protected void changeImage(int imageId, CardView cardView) {
        ImageView imageView = (ImageView) cardView.findViewById(R.id.imageInCard);
        imageView.setImageResource(imageId);
    }
}