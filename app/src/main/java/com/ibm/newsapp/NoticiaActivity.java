package com.ibm.newsapp;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.util.Date;

public class NoticiaActivity extends AppCompatActivity {
    String imageUrl, title, description, content, author, date, url;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        ImageView imageView = findViewById(R.id.imageNews);
        TextView titleView = findViewById(R.id.titulo);
        TextView contentView = findViewById(R.id.conteudo);
        TextView descriptionView = findViewById(R.id.description);
        TextView authorView = findViewById(R.id.autor);
        TextView dataView = findViewById(R.id.data);
        Button button = findViewById(R.id.saibaMaisButton);

        imageUrl = getStringDataFromBundle(UltimasNoticiasActivity.URLIMAGE);
        title = getStringDataFromBundle(UltimasNoticiasActivity.TITLE);
        description = compareAndGetDescription();
        content = getStringDataFromBundle(UltimasNoticiasActivity.CONTENT);
        author = getStringDataFromBundle(UltimasNoticiasActivity.AUTHOR);
        date = getStringDataFromBundle(UltimasNoticiasActivity.DATA);
        url = getStringDataFromBundle(UltimasNoticiasActivity.URL);

        titleView.setText(title);
        descriptionView.setText(description);
        contentView.setText(formatContent(content));
        authorView.setText(author);
        dataView.setText(formatDate(date));
        Glide.with(getApplicationContext())
                .load(imageUrl)
                .into(imageView);

        buttonSaibaMaisListener(button, url);

    }

    protected String getStringDataFromBundle(String key){
        Bundle extras = getIntent().getExtras();
        return extras.getString(key);
    }

    protected String compareAndGetDescription(){
        String desc = getStringDataFromBundle(UltimasNoticiasActivity.DESCRIPTION);
        if (desc.equals(content)) {
            return "";
        }

        return desc;
    }

    protected String formatDate(String date){
        SimpleDateFormat spf;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            spf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date newDate;
            try {
                newDate = spf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return date;
            }
            spf = new SimpleDateFormat("dd/MM/yyyy");
            return spf.format(newDate);
        }
        return date;
    }

    protected String formatContent(String content){
        if (content ==  null) {
            return content;
        }

        String[] parts = content.split("\\[");
        return parts[0] + "Para ler a notícia completa, clique no botão abaixo.";
    }

    protected void buttonSaibaMaisListener(Button button, String url){
        button.setOnClickListener(view -> {
            Intent intent = new Intent(NoticiaActivity.this, SaibaMaisActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(UltimasNoticiasActivity.URL, url);
            intent.putExtras(bundle);

            startActivity(intent);
        });
    }

}


