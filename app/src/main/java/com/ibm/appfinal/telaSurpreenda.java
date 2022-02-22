package com.ibm.appfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class telaSurpreenda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_surpreenda);
    }


    public void abrirVideo(View view) {
        startActivity(new Intent(this, telaUltima.class));
    }
}




