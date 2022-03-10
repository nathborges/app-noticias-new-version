package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NoticiaActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        ImageView image = findViewById(R.id.imageNews);
        TextView titulo = findViewById(R.id.titulo);

        Bundle bundle = getIntent().getExtras();
        Article article = bundle.getParcelable("artigo");

        titulo.setText(article.getTitulo());




    };

}


