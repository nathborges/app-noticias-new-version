package com.ibm.appfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class noticia extends AppCompatActivity {

    Button botaoSaibaMais, botaoSupreenda, botaoEntrar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);
        botaoSaibaMais = findViewById(R.id.bt_saiba);
        botaoSupreenda = findViewById(R.id.bt_surpreenda);

        botaoSaibaMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saibaMais = new Intent(getApplicationContext(), com.ibm.appfinal.saibaMais.class);
                startActivity(saibaMais);

            }
        });

        botaoSupreenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(noticia.this, telaSurpreenda.class);
                startActivity(it);

            }
        });

    }

}