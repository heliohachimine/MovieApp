package com.example.helio.testmovie.ui.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.helio.testmovie.BR;

public class MovieDetailModel extends BaseObservable {

    private String Title;
    private String Year;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Country;
    private String Poster;
    private String imdbRating;
    private String imdbID;

    public MovieDetailModel(){
    }

    public MovieDetailModel(String title, String year, String released, String runtime,
                            String genre, String director, String writer, String actors,
                            String plot, String country, String poster, String imdbRating, String imdbID ) {
        Title = title;
        Year = year;
        Released = released;
        Runtime = runtime;
        Genre = genre;
        Director = director;
        Writer = writer;
        Actors = actors;
        Plot = plot;
        Country = country;
        Poster = poster;
        this.imdbRating = imdbRating;
        this.imdbID = imdbID;

    }

    @Bindable
    public String getTitle() {
        return Title;
    }
    @Bindable
    public String getYear() {
        return Year;
    }
    @Bindable
    public String getReleased() {
        return Released;
    }
    @Bindable
    public String getRuntime() {
        return Runtime;
    }
    @Bindable
    public String getGenre() {
        return Genre;
    }
    @Bindable
    public String getDirector() {
        return Director;
    }
    @Bindable
    public String getWriter() {
        return Writer;
    }
    @Bindable
    public String getActors() {
        return Actors;
    }
    @Bindable
    public String getPlot() {
        return Plot;
    }
    @Bindable
    public String getCountry() {
        return Country;
    }
    @Bindable
    public String getPoster() {
        return Poster;
    }
    @Bindable
    public String getImdbRating() {
        return imdbRating;
    }
    @Bindable
    public String getImdbID() {
        return imdbID;
    }

    public void setTitle(String title) {
        Title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setYear(String year) {
        Year = year;
        notifyPropertyChanged(BR.year);
    }

    public void setReleased(String released) {
        Released = released;
        notifyPropertyChanged(BR.released);
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
        notifyPropertyChanged(BR.runtime);
    }

    public void setGenre(String genre) {
        Genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    public void setDirector(String director) {
        Director = director;
        notifyPropertyChanged(BR.director);
    }

    public void setWriter(String writer) {
        Writer = writer;
        notifyPropertyChanged(BR.writer);
    }

    public void setActors(String actors) {
        Actors = actors;
        notifyPropertyChanged(BR.actors);
    }

    public void setPlot(String plot) {
        Plot = plot;
        notifyPropertyChanged(BR.plot);
    }

    public void setCountry(String country) {
        Country = country;
        notifyPropertyChanged(BR.country);
    }

    public void setPoster(String poster) {
        Poster = poster;
        notifyPropertyChanged(BR.poster);
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
        notifyPropertyChanged(BR.imdbRating);
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
        notifyPropertyChanged(BR.imdbID);
    }
}
