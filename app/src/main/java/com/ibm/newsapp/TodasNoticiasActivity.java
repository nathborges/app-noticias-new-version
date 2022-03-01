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
        LinearLayout child = findViewById(R.id.childOfScrollView);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        CardView cardView1 = (CardView) inflater.inflate(R.layout.container, null);
        CardView cardView2 = (CardView) inflater.inflate(R.layout.container, null);
        CardView cardView3 = (CardView) inflater.inflate(R.layout.container, null);
        CardView cardView4 = (CardView) inflater.inflate(R.layout.container, null);
        CardView cardView5 = (CardView) inflater.inflate(R.layout.container, null);

        child.addView(cardView1);
        child.addView(cardView2);
        child.addView(cardView3);
        child.addView(cardView4);
        child.addView(cardView5);

        changeImage(R.drawable.foto, cardView1);
        changeTitle("Teste", cardView1);
        changeText("aaaaaaaaa", cardView1);
    }

    protected void changeTitle(CharSequence title, CardView cardView) {
        TextView textView = (TextView) cardView.findViewById(R.id.titleInCard);
        textView.setText(title);
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