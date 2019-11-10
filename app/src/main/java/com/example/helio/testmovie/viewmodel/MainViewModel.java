package com.example.helio.testmovie.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.helio.testmovie.repository.BDRepository;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.model.MovieModel;

import java.util.ArrayList;

public class MainViewModel {

    public MovieModel movie = new MovieModel();

    private MovieRepository repository = new MovieRepository();
    private BDRepository bdRepository = new BDRepository();

    public ArrayList<MovieModel> movies;

    public MovieRepository.Interator interator = null;

    private Context context;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public LiveData<Boolean> clickAddMovie() {
        LiveData<Boolean> isLoading = repository.searchMovies(movie.getTitle(), "1", interator);
        return isLoading;

    }


}

