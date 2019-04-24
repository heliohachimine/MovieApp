package com.example.helio.testmovie.service;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public MovieService getMovieService(){
        return this.retrofit.create(MovieService.class);
    }

}
