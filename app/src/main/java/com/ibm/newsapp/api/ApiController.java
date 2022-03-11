package com.ibm.newsapp.api;

import com.ibm.newsapp.models.Article;
import com.ibm.newsapp.models.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiController {
    private static final String API_KEY = "dd6bd4beedbb4832823b347d5ac76b42";
    private static List<Article> allArticles = new ArrayList<>();
    private static List<Article> allArticlesByCategory = new ArrayList<>();
    private static final String country = "br";
    private static Call<News> call;
    private static String category;
    private static final ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


    public static void fetchAllData() {
        call = apiInterface.getNews(country, API_KEY);

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

    public static void fetchAllDataByCategory(String categoryChosed){
        call = apiInterface.getNewsByCategory(country, categoryChosed, API_KEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {


                if (response.isSuccessful() && response.body().getArticle() != null) {

                    allArticlesByCategory = response.body().getArticle();
                    category = categoryChosed;

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

    public static String getCategory() {
        return category;
    }

    public static List<Article> getAllArticlesByCategory() {
        return allArticlesByCategory;
    }
}