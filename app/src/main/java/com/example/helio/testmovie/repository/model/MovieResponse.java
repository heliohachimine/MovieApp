package com.example.helio.testmovie.repository.model;

import com.example.helio.testmovie.ui.model.MovieModel;

import java.util.ArrayList;

public class MovieResponse {

    public ArrayList<MovieModel> Search;
    private String totalResults;
    private boolean Response;

    public ArrayList<MovieModel> getMovies(){
        return this.Search;
    }
}
