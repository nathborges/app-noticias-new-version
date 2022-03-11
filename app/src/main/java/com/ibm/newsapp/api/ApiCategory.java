package com.ibm.newsapp.api;

import com.ibm.newsapp.Article;
import com.ibm.newsapp.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCategory {
    private static List<Article> articles = new ArrayList<>();

    public static void fetchData(String categoryChoose) {

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        String country = "br";
        String category = categoryChoose;


        Call<News> call;

        call = apiInterface.getNews(country, ApiInterface.API_KEY);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {


                if (response.isSuccessful() && response.body().getArticle() != null) {

                    if (!articles.isEmpty()) {
                        articles.clear();
                    }

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

    public static List<Article> getArticles() {
        return articles;
    }

    public static void setArticles(List<Article> articles) {
        ApiLastNews.articles = articles;
    }

}
