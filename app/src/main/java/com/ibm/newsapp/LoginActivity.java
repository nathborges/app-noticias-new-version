package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

        EditText email, senha;
        Button botaoEntrar;
        TextView cadastre;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

                email = (EditText) findViewById(R.id.text_email);
                senha = (EditText) findViewById(R.id.text_senha);
                botaoEntrar = (Button) findViewById(R.id.bt_entrar);
                cadastre = (TextView) findViewById(R.id.cadastreSe);

                //BOTAO QUE PERMITE QUE O USER ENTRE NO APLICATIVO ATRAVÉS DE E-MAIL E SENHA
                botaoEntrar.setOnClickListener(v -> {
                        checkIfEmpty();
                });

                //QUANDO O USER CLICAR EM "CADASTRE-SE", SERÁ DIRECIONADO PARA A TELA DE CADASTRO **TELA DE NOTÍCIA USADA SÓ PARA TESTE**
                cadastre.setOnClickListener(v -> {
                        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                        startActivity(intent);
                });

        }

        // FUNÇAO QUE VERIFICA SE OS CAMPOS DO E-MAIL E SENHA ESTAO VAZIOS. CASO POSITIVO, EXIBE ALERT. CASO NEGATIVO, DEIXA O USER LOGAR NO APP
        private void checkIfEmpty(){
                EditText campoEmail = findViewById(R.id.text_email);
                EditText campoSenha = findViewById(R.id.text_senha);

                String email = campoEmail.getText().toString();
                String senha = campoSenha.getText().toString();

                if (email.matches("") || senha.matches("")){
                        //INSTANCIAR ALERT DIALOG
                        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

                        //CONFIGURAR MENSAGEM
                        dialog.setMessage("Preencha os campos para efetuar o login.");

                        //CONFIGURAR SIM E NAO
                        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                        });

                        //CRIAR E EXIBIR A DIALOG
                        dialog.create();
                        dialog.show();
                }
                else{
                        Intent intent = new Intent(LoginActivity.this, NoticiaActivity.class);
                        startActivity(intent);
                }
        }
}






















