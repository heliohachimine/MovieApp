package com.example.helio.testmovie.repository;

import android.content.Context;
import android.util.Log;

import com.example.helio.testmovie.data.DBMovie;
import com.example.helio.testmovie.data.DBMovieException;
import com.example.helio.testmovie.ui.model.MovieDetailModel;

import java.util.ArrayList;


public class BDRepository {

    public void insertMovie(Context context, MovieDetailModel movie){
        try {
            DBMovie.dbInit(context);
            DBMovie.insertMovie(movie);
            Log.d("BD","Insert sucess");
        } catch (DBMovieException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MovieDetailModel> getAllMovies(Context context){
        ArrayList<MovieDetailModel> movies;
        try {
            DBMovie.dbInit(context);
             movies = DBMovie.getMovieInfo();
            Log.d("BD","Insert sucess");
        } catch (DBMovieException e) {
            e.printStackTrace();
            movies = null;
        }
        return movies;
    }
}
