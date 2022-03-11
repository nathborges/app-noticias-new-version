package com.ibm.newsapp.api;


import com.ibm.newsapp.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
        String API_KEY = "0c11495d265a4afc96a15b756667b90e";

        @GET("top-headlines")
        Call<News> getNews(

                @Query("country") String country ,
                @Query("apiKey") String apiKey

        );

        @GET("top-headlines-category")
        Call<News> getNewsByCategory(

                @Query("country") String country ,
                @Query("category") String category,
                @Query("apiKey") String apiKey

        );

}