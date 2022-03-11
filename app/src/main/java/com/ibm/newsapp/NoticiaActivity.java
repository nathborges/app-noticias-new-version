package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NoticiaActivity extends AppCompatActivity {
    Intent intent = getIntent();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        ImageView image = findViewById(R.id.imageNews);
        TextView title = findViewById(R.id.titulo);
        TextView content = findViewById(R.id.conteudo);
        TextView description = findViewById(R.id.description);
        TextView author = findViewById(R.id.autor);
        TextView data = findViewById(R.id.data);

        title.setText("Pressionado por policiais, Zema chama coletiva sobre reajuste salarial");
        description.setText(getStringDataFromBundle(UltimasNoticiasActivity.DESCRIPTION));
        content.setText(getStringDataFromBundle(UltimasNoticiasActivity.CONTENT));
        author.setText(getStringDataFromBundle(UltimasNoticiasActivity.AUTHOR));
        data.setText(getStringDataFromBundle(UltimasNoticiasActivity.DATA));
        Glide.with(getApplicationContext())
                .load(getStringDataFromBundle(UltimasNoticiasActivity.URLIMAGE))
                .into(image);

    };

    protected String getStringDataFromBundle(String key){
        Bundle extras = getIntent().getExtras();
        return extras.getString(key);
    }

}


