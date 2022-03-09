package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class UltimasNoticiasActivity extends AppCompatActivity {

    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimas_noticias);

        createCards();
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

    protected void createCard() {
        LinearLayout linearLayoutDaScrollView= findViewById(R.id.childOfLastNewsScrollView);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        CardView aleatorio = (CardView) inflater.inflate(R.layout.container, null);
        linearLayoutDaScrollView.addView(aleatorio);
    }

    protected void createCards() {
        List<Article> listaArticles= API.getArticles();

        int x = listaArticles.size();

        for(int i = 0; i < x; i++){
           Article article = listaArticles.get(i);

            LinearLayout linearLayoutDaScrollView= findViewById(R.id.childOfLastNewsScrollView);

            LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
            CardView cardNovo = (CardView) inflater.inflate(R.layout.container, null);

            TextView titleTxt = cardNovo.findViewById(R.id.titleInCard);
            titleTxt.setText(article.getTitulo());

            TextView textTxt = cardNovo.findViewById(R.id.textInCard);
            textTxt.setText(article.getSource().getName());

            linearLayoutDaScrollView.addView(cardNovo);
        }
    }
}