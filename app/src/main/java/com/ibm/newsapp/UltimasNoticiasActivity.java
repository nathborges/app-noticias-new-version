package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UltimasNoticiasActivity extends AppCompatActivity {

    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimas_noticias);
        LinearLayout childOfScrollView = findViewById(R.id.childOfLastNewsScrollView);

        //todo: contar o número de notícias na api e criar programaticamente os cards
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        CardView aleatorio = (CardView) inflater.inflate(R.layout.container, null);
        CardView aleatorio1 = (CardView) inflater.inflate(R.layout.container, null);
        CardView aleatorio2 = (CardView) inflater.inflate(R.layout.container, null);

        changeImage(R.drawable.tecnologia, aleatorio);
        changeImage(R.drawable.economia, aleatorio1);
        changeImage(R.drawable.esportes, aleatorio2);

        TextView titleInCard = aleatorio.findViewById(R.id.titleInCard);

        api = new API();
        api.fetchData(titleInCard);

        aleatorio.setOnClickListener(v -> {
            clickSelectedNews();
        });

        aleatorio1.setOnClickListener(v -> {
            clickSelectedNews();
        });

        aleatorio2.setOnClickListener(v -> {
            clickSelectedNews();
        });

        childOfScrollView.addView(aleatorio);
        childOfScrollView.addView(aleatorio1);
        childOfScrollView.addView(aleatorio2);
    }

    protected void changeTitle(CharSequence text, CardView cardView) {
        TextView textView = cardView.findViewById(R.id.titleInCard);
        textView.setText(text);
    }

    protected void changeText(CharSequence text, CardView cardView) {
        TextView textView = cardView.findViewById(R.id.textInCard);
        textView.setText(text);
    }

    protected void changeImage(int imageId, CardView cardView) {
        ImageView imageView = cardView.findViewById(R.id.imageInCard);
        imageView.setImageResource(imageId);
    }

    protected void clickSelectedNews() {
        Intent intent = new Intent(UltimasNoticiasActivity.this, NoticiaActivity.class);
        startActivity(intent);
    }
}