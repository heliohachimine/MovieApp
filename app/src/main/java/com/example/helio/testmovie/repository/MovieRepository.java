package com.example.helio.testmovie.repository;

import android.arch.lifecycle.MutableLiveData;

import com.example.helio.testmovie.repository.model.MovieDetailResponse;
import com.example.helio.testmovie.service.MovieService;
import com.example.helio.testmovie.service.RetrofitConfig;
import com.example.helio.testmovie.ui.model.MovieDetailModel;
import com.example.helio.testmovie.ui.model.MovieModel;
import com.example.helio.testmovie.repository.model.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieRepository {

    private MovieService service;
    private RetrofitConfig retrofit;
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public MutableLiveData<Boolean> searchMovies(String title, String page, final Interator callbackService) {

        retrofit = new RetrofitConfig();
        service = retrofit.getMovieService();

        Call<MovieResponse> call = service.searchMovies(title, "49443b8a", page);
        isLoading.setValue(true);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(retrofit2.Call<MovieResponse> call, Response<MovieResponse> response) {
                callbackService.updateMovies(response.body().Search);
                isLoading.setValue(false);

            }

            @Override
            public void onFailure(retrofit2.Call<MovieResponse> call, Throwable t) {
                callbackService.onErrorResult();
                isLoading.setValue(false);
            }
        });
        return isLoading;
    }


    public  MutableLiveData<Boolean> loadDetailMovie(String imdbId, final Interator callbackService) {

        retrofit = new RetrofitConfig();
        service = retrofit.getMovieService();

        Call<MovieDetailResponse> call = service.getDetailMovie(imdbId, "49443b8a");
        isLoading.setValue(true);
        call.enqueue(new Callback<MovieDetailResponse>() {
            @Override
            public void onResponse(retrofit2.Call<MovieDetailResponse> call, Response<MovieDetailResponse> response) {
                callbackService.loadDetailsMovie(new MovieDetailModel(response.body().getTitle(), response.body().getYear(),
                        response.body().getReleased(), response.body().getRuntime(), response.body().getGenre(),
                        response.body().getDirector(), response.body().getWriter(), response.body().getActors(),
                        response.body().getPlot(), response.body().getCountry(), response.body().getPoster(),
                        response.body().getImdbRating(), response.body().getImdbID()));
                isLoading.setValue(false);

            }

            @Override
            public void onFailure(retrofit2.Call<MovieDetailResponse> call, Throwable t) {
                callbackService.onErrorResult();
                isLoading.setValue(false);
            }
        });
        return isLoading;
    }


    public interface Interator {
        void updateMovies(ArrayList<MovieModel> movies);

        void updateFavoriteMovies(ArrayList<MovieDetailModel> movies);

        void onClickDetail(String imdbId);

        void loadDetailsMovie(MovieDetailModel movie);

        void onErrorResult();
    }
}
