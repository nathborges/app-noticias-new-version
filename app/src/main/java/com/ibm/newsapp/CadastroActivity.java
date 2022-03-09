package com.ibm.newsapp;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CadastroActivity extends AppCompatActivity {

    private EditText editTextNome, editTextEmail, editTextPassword;
    private androidx.appcompat.widget.AppCompatButton bt_entrar3;
    String[] mensagens = {"Por favor, preencha todos os campos.", "Cadastro realizado com sucesso!"};
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        startComponents();

        bt_entrar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || password.isEmpty()){
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
        String nome = editTextNome.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            //OBJETO RESPONSÁVEL PELO CADASTRO E AUTENTICACAO DO USER
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    //SALVANDO DADOS DO USUÁRIO, COMO O NOME, NO NOSSO CASO.
                    SaveUserData();

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

    //TODO: VER PQ NAO TA SALVANDO A COLECAO NO CONSOLE
    private void SaveUserData(){
        String nome = editTextNome.getText().toString();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //GUARDANDO OS DADOS DO USUÁRIO USANDO MAP
        Map<String, Object> usuarios = new HashMap<>();
        usuarios.put("nome",nome);

        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("Usuarios").document(userID);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("db", "sucesso ao salvar os dados");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("db error", "Erro ao salvar os dados" + e.toString());
            }
        });


    }

    private void startComponents(){
        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        bt_entrar3 = findViewById(R.id.bt_entrar3);
    }
}