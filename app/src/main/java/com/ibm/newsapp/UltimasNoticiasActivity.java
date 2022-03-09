package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.util.List;

public class UltimasNoticiasActivity extends AppCompatActivity {

    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimas_noticias);

        createCards();
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
            titleTxt.setText(stringAfterCheck(article.getTitulo(), "-"));

            TextView textTxt = cardNovo.findViewById(R.id.textInCard);
            textTxt.setText(stringAfterCheck(article.getSource().getName(), ".com"));

            ImageView imgView = cardNovo.findViewById(R.id.imageInCard);

            Glide.with(getApplicationContext())
                    .load(article.getUrlImagem())
                    .into(imgView);

            linearLayoutDaScrollView.addView(cardNovo);
        }
    }

    protected String stringAfterCheck(String source, String removeString) {
        if (!source.contains(removeString)){
            return source;
        }

        String[] parts = source.split(removeString);
        return parts[0];
    }
}