package com.example.helio.testmovie.viewmodel;

import android.content.Context;
import android.util.Log;

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

    public void clickAddMovie(){
        Log.i("teste", "clicou o botao");
        if(!movie.getTitle().isEmpty() && (movie != null)){
            repository.searchMovies(movie.getTitle(), "1", interator);

        }
    }



}

