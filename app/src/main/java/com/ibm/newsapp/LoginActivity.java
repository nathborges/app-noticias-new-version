package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

        EditText email, senha;
        Button botaoEntrar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

                email = (EditText) findViewById(R.id.text_email);
                senha = (EditText) findViewById(R.id.text_senha);
                botaoEntrar = (Button) findViewById(R.id.bt_entrar);



                botaoEntrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                startActivity(new Intent (LoginActivity.this, NoticiaActivity.class));


                        }
                });

        }

        }






















