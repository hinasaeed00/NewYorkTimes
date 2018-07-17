package com.example.newyorktime.newyorktimes.API;

import com.example.newyorktime.newyorktimes.Model.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("mostpopular/v2/mostviewed/all-sections/7.json")
    Call<ArticleResponse> getPopularArticles(@Query("api_key") String apiKey);

}
