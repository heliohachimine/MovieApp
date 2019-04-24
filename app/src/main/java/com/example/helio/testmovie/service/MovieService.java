package com.example.helio.testmovie.service;

import com.example.helio.testmovie.repository.model.MovieDetailResponse;
import com.example.helio.testmovie.repository.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("?plot=full")
    Call<MovieResponse> searchMovies(@Query("s") String movieName, @Query("apikey") String apikey, @Query("page") String page);

    @GET("?")
    Call<MovieDetailResponse> getDetailMovie(@Query("i") String imdbId, @Query("apikey") String apikey);
}
