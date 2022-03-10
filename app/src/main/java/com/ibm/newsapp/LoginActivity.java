package com.ibm.newsapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

        EditText text_email, text_senha;
        androidx.appcompat.widget.AppCompatButton bt_entrar;
        TextView cadastre, esqueciSenha;
        String[] mensagens = {"Por favor, preencha todos os campos.", "Login realizado com sucesso!"};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

                text_email = (EditText) findViewById(R.id.text_email);
                text_senha = (EditText) findViewById(R.id.text_senha);
                bt_entrar = (androidx.appcompat.widget.AppCompatButton) findViewById(R.id.bt_entrar);
                cadastre = (TextView) findViewById(R.id.cadastreSe);
                esqueciSenha =  (TextView) findViewById(R.id.esqueciSenha);

                //BOTAO QUE PERMITE QUE O USER ENTRE NO APLICATIVO ATRAVÉS DE E-MAIL E SENHA
                bt_entrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                                String email = text_email.getText().toString();
                                String senha = text_senha.getText().toString();

                                if (email.isEmpty() || senha.isEmpty()) {
                                        Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                                        snackbar.setBackgroundTint(Color.rgb(82, 12, 97));
                                        snackbar.setTextColor(Color.WHITE);
                                        snackbar.show();
                                } else {
                                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task) {
//
                                                        if (task.isSuccessful()){
                                                                Intent intent = new Intent(LoginActivity.this, CategoriasNoticiasActivity.class);
                                                                startActivity(intent);
                                                                finish();
                                                        } else {
                                                                String error;
                                                                try{
                                                                        throw task.getException();
                                                                } catch (Exception e){
                                                                        error = "Erro ao efetuar o login.";
                                                                }
                                                                Snackbar snackbar = Snackbar.make(v, error, Snackbar.LENGTH_SHORT);
                                                                snackbar.setBackgroundTint(Color.rgb(82, 12, 97));
                                                                snackbar.setTextColor(Color.WHITE);
                                                                snackbar.show();
                                                        }
                                                }
                                        });
                                }
                        }
                });

                //QUANDO O USER CLICAR EM "CADASTRE-SE", SERÁ DIRECIONADO PARA A TELA DE CADASTRO **TELA DE NOTÍCIA USADA SÓ PARA TESTE**
                cadastre.setOnClickListener(v -> {
                        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                        startActivity(intent);
                });

                //QUANDO O USER CLICAR EM "ESQUECI A SENHA", SERÁ DIRECIONADO PARA A TELA ESQUECEU A SENHA **
                esqueciSenha.setOnClickListener(v -> {
                        Intent intent = new Intent(LoginActivity.this, EsqueceuSenhaActivity.class);
                        startActivity(intent);
                });

        }

}






















