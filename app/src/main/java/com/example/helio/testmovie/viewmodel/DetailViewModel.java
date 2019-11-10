package com.example.helio.testmovie.viewmodel;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.databinding.ObservableField;
import android.util.Log;
import android.widget.Toast;

import com.example.helio.testmovie.data.DBMovie;
import com.example.helio.testmovie.data.DBMovieException;
import com.example.helio.testmovie.repository.BDRepository;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.model.MovieDetailModel;

public class DetailViewModel {

    public MovieDetailModel movie = new MovieDetailModel();
    private MovieRepository repository = new MovieRepository();
    private BDRepository bdRepository = new BDRepository();
    public MovieRepository.Interator interator = null;
    public Context context;

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> year = new ObservableField<>();
    public ObservableField<String> released = new ObservableField<>();
    public ObservableField<String> runtime = new ObservableField<>();
    public ObservableField<String> genre = new ObservableField<>();
    public ObservableField<String> director = new ObservableField<>();
    public ObservableField<String> writer = new ObservableField<>();
    public ObservableField<String> actors = new ObservableField<>();
    public ObservableField<String> plot = new ObservableField<>();
    public ObservableField<String> country = new ObservableField<>();
    public ObservableField<String> poster = new ObservableField<>();
    public ObservableField<String> imdbRating = new ObservableField<>();

    public DetailViewModel(MovieRepository.Interator interator, Context context
    ){ this.interator = interator;
    this.context = context;}

    public LiveData<Boolean> loadMovie(String imdbId){
        LiveData<Boolean> isLoading = repository.loadDetailMovie(imdbId, interator);
        return isLoading;
    }

    public void setMovie(MovieDetailModel movie){
        this.movie = movie;
        title.set(movie.getTitle());
        year.set(movie.getYear());
        released.set(movie.getReleased());
        runtime.set(movie.getRuntime());
        genre.set(movie.getGenre());
        director.set(movie.getDirector());
        writer.set(movie.getWriter());
        actors.set(movie.getActors());
        plot.set(movie.getPlot());
        country.set(movie.getCountry());
        poster.set(movie.getPoster());
        imdbRating.set(movie.getImdbRating());

    }

    public MovieDetailModel getMovie(){
        return this.movie;
    }

    public void clickSave(){
        bdRepository.insertMovie(context, this.movie);
    }
}
