package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class NoticiaActivity extends AppCompatActivity {

    Button botaoSaibaMais, botaoSupreenda, botaoEntrar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);
        colorBar();
        //botaoSaibaMais = findViewById(R.id.bt_saiba);
        //botaoSupreenda = findViewById(R.id.bt_surpreenda);

        //botaoSaibaMais.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //   public void onClick(View view) {
        //     Intent saibaMais = new Intent(getApplicationContext(), SaibaMaisActivity.class);
        //     startActivity(saibaMais);

        //   }
        //});

        // botaoSupreenda.setOnClickListener(new View.OnClickListener() {
        //   @Override
        // public void onClick(View view) {
        //    Intent it = new Intent(NoticiaActivity.this, SurpreendaActivity.class);
        //   startActivity(it);

        // }
    };

    protected void colorBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

}

