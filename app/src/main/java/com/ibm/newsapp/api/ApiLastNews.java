package com.ibm.newsapp.api;


import com.ibm.newsapp.Article;
import com.ibm.newsapp.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiLastNews {
    private static List<Article> allArticles = new ArrayList<>();
    private static List<Article> allArticlesByCategory = new ArrayList<>();
    private static String country = "br";
    private static Call<News> call;
    private static ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


    public static void fetchAllData() {
        call = apiInterface.getNews(country, ApiInterface.API_KEY);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {


                if (response.isSuccessful() && response.body().getArticle() != null) {

                    if (!allArticles.isEmpty()) {
                        allArticles.clear();
                    }

                    allArticles = response.body().getArticle();

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

    public static List<Article> getAllArticles() {
        return allArticles;
    }

    public static fetchAllDataByCategory(String categoryChosed){

    }
}