package com.ibm.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ibm.newsapp.api.ApiController;
import com.ibm.newsapp.models.Article;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UltimasNoticiasActivity extends AppCompatActivity {

    private static List<Article> listaArticles;

    public static final String TITLE = "titulo";
    public static final String URLIMAGE = "urlImage";
    public static final String AUTHOR = "author";
    public static final String DATA = "data";
    public static final String CONTENT = "content";
    public static final String DESCRIPTION = "description";
    public static final String URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimas_noticias);

        Button button = findViewById(R.id.lastnewsButton);
        button.setShadowLayer(2,1,1,getResources().getColor(R.color.purple));

        listaArticles = ApiController.getAllArticles();
        createCards();
    }

    protected void createCards() {
        int x = listaArticles.size();

        for(int i = 0; i < x; i++){
           Article article = listaArticles.get(i);

           String source = article.getSource().getName();
           if (source.equals("YouTube")) {
               x--;
               continue;
           }

            if (article.getConteudo() == null) {
                x--;
                continue;
            }

            LinearLayout linearLayoutDaScrollView= findViewById(R.id.childOfLastNewsScrollView);

            LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
            CardView cardNovo = (CardView) inflater.inflate(R.layout.container, null);

            TextView titleTxt = cardNovo.findViewById(R.id.titleInCard);
            String tituloDoArtigo = article.getTitulo();
            titleTxt.setText(tituloDoArtigo);

            TextView textTxt = cardNovo.findViewById(R.id.textInCard);
            textTxt.setText(formatDate(article.getDataDePublicacao()));

            ImageView imgView = cardNovo.findViewById(R.id.imageInCard);

            Glide.with(getApplicationContext())
                    .load(article.getUrlImagem())
                    .into(imgView);

            click(cardNovo, article);

            linearLayoutDaScrollView.addView(cardNovo);
        }
    }

    protected String stringAfterCheck(String source, String removeString) {
        if (!source.contains(removeString)){
            return source;
        }

        String[] parts = source.split(removeString);
        return parts[0];
    }

    protected void click(CardView card, Article article){
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UltimasNoticiasActivity.this, NoticiaActivity.class);
                Bundle bundle = new Bundle();
                checkDataValueAndPutOnBundle(URLIMAGE, article.getUrlImagem(), bundle);
                checkDataValueAndPutOnBundle(AUTHOR, article.getAutor(), bundle);
                checkDataValueAndPutOnBundle(DATA, article.getDataDePublicacao(), bundle);
                checkDataValueAndPutOnBundle(TITLE, article.getTitulo(), bundle);
                checkDataValueAndPutOnBundle(CONTENT, article.getConteudo(), bundle);
                checkDataValueAndPutOnBundle(DESCRIPTION, article.getDescricao(), bundle);
                checkDataValueAndPutOnBundle(URL, article.getUrl(), bundle);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }

    protected void checkDataValueAndPutOnBundle(String key, String data, Bundle bundle) {
        if (data == null) {
            return;
        }
        bundle.putString(key, data);
    }

    protected String formatDate(String date){
        SimpleDateFormat spf;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            spf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date newDate;
            try {
                newDate = spf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return date;
            }
            spf = new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm");
            return spf.format(newDate);
        }
        return date;
    }
}