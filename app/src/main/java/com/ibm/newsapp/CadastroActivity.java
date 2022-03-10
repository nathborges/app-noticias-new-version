package com.ibm.newsapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {

    private EditText text_nome, editTextEmail,editConfirmationPassword,  editTextPassword;
    private androidx.appcompat.widget.AppCompatButton button;
    String[] mensagens = {"Por favor, preencha todos os campos.", "Cadastro realizado com sucesso!"};
    TextView btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btn_voltar = (TextView) findViewById(R.id.back);

        startComponents();

        btn_voltar.setOnClickListener(v -> {
            Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = text_nome.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmation = editConfirmationPassword.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || password.isEmpty() || confirmation.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(82, 12, 97));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }else{
                    RegisterUser(view);
                }
            }
        });
    }

    private void RegisterUser(View view){
        String nome = text_nome.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmation = editConfirmationPassword.getText().toString();



        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            //OBJETO RESPONSÁVEL PELO CADASTRO E AUTENTICACAO DO USER
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Snackbar snackbar = Snackbar.make(view,mensagens[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(82, 12, 97));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                } else {
                    String error;
                    try {
                        throw task.getException();
                    }catch(FirebaseAuthWeakPasswordException e){
                        error = "Digite uma senha com no mínimo 6 caracteres.";
                    }catch(FirebaseAuthUserCollisionException e){
                        error = "Conta já cadastrada.";
                    }catch(FirebaseAuthInvalidCredentialsException e){
                        error = "e-mail inválido.";
                    }
                    catch(Exception e){
                        error = "Erro ao cadastrar usuário.";
                    }

                    Snackbar snackbar = Snackbar.make(view,error,Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.rgb(82, 12, 97));
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }
            }
        });
    }

    private void startComponents(){
        text_nome = findViewById(R.id.text_nome);
        editTextEmail = findViewById(R.id.text_email);
        editTextPassword = findViewById(R.id.text_senha);
        editConfirmationPassword = findViewById(R.id.text_confirmacao);
        button = findViewById(R.id.bt_cadastro);
    }
}