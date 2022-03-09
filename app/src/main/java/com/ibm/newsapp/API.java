package com.ibm.newsapp;

import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class API {
    public static final String API_KEY = "0c11495d265a4afc96a15b756667b90e";
    private static List<Article> articles = new ArrayList<>();
    public static int numeroDeArtigos = 0;

    public static void fetchData() {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        String country = "br";
        String language = "pt";

        Call<News> call;

        call = apiInterface.getNews(country, API_KEY);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {


                if (response.isSuccessful() && response.body().getArticle() != null) {

                    if (!articles.isEmpty()) {
                        articles.clear();
                    }

                    setNumeroArtigos(response.body().getTodosOsResultados());


                    articles = response.body().getArticle();

                } else {
                    String errorCode;
                    switch (response.code()) {
                        case 404:
                            errorCode = "404 not found";
                            break;
                        case 500:
                            errorCode = "500 server broken";
                            break;
                        default:
                            errorCode = "unknown error";
                            break;
                    }

                    //TODO: ALERT DE ERRO
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                System.out.println("aaaaaaa");
            }
        });
    }

    public static void setNumeroArtigos(int numeroArtigos) {
        API.numeroDeArtigos = numeroArtigos;
    }

    public static int getNumeroDeArtigos() {
        return API.numeroDeArtigos;
    }
}