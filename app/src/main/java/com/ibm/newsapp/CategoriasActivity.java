package com.ibm.newsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.ibm.newsapp.api.ApiController;

public class CategoriasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_noticias);


        CardView techCard = findViewById(R.id.categoryTech);
        CardView businessCard = findViewById(R.id.categoryEconomy);
        CardView sportsCard = findViewById(R.id.categorySports);
        CardView healthCard = findViewById(R.id.categoryHealth);
        CardView enterCard = findViewById(R.id.categoryEnter);
        CardView scienceCard = findViewById(R.id.categoryScience);

        click(techCard, "technology");
        click(businessCard, "business");
        click(sportsCard, "sports");
        click(healthCard, "health");
        click(enterCard, "entertainment");
        click(scienceCard, "science");
    }

    protected void click(CardView card, String categoryName) {
        card.setOnClickListener(v -> {
            ApiController.fetchAllDataByCategory(categoryName);
            Intent intent = new Intent(CategoriasActivity.this, UltimasNoticiasPorCategoria.class);
            intent.putExtra("categorySelected", categoryName);
            startActivity(intent);
        });
    }
}