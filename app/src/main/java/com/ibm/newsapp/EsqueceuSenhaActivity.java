package com.ibm.newsapp;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class EsqueceuSenhaActivity extends AppCompatActivity {

    EditText email;
    Button enviar;
    TextView voltar;
    String[] mensagens = {"Por favor, preencha todos os campos.", "Email encaminhado com sucesso!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_senha);

        email = (EditText) findViewById(R.id.text_email);
        enviar = (Button) findViewById(R.id.bt_enviar);
        voltar = (TextView) findViewById(R.id.voltar);

        enviar.setOnClickListener(view -> {

            EditText campoEmail = findViewById(R.id.text_email);

            String email = campoEmail.getText().toString();

            if (email.isEmpty()){
                Snackbar snackbar = Snackbar.make(view,mensagens[0],Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.rgb(82, 12, 97));
                snackbar.setTextColor(Color.WHITE);
                snackbar.show();
            }
            else{
                Snackbar snackbar = Snackbar.make(view,mensagens[1],Snackbar.LENGTH_SHORT);
                snackbar.setBackgroundTint(Color.rgb(82, 12, 97));
                snackbar.setTextColor(Color.WHITE);
                snackbar.show();
            }
        });

        voltar.setOnClickListener(v -> {
            Intent intent = new Intent(EsqueceuSenhaActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}

