package com.example.newyorktime.newyorktimes.API;

import com.example.newyorktime.newyorktimes.Constants.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    public static String NYAPI_KEY="59603b790f5145fa8ffc79fa30a42111";
    public static String API_BASE_URL="http://api.nytimes.com/svc/";
    public static String MOST_POPULAR_ARTICLES= API_BASE_URL+"/svc/mostpopular/v2/mostviewed/all-sections/7.json?"+NYAPI_KEY;
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
