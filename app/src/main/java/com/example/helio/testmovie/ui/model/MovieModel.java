package com.example.helio.testmovie.ui.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.helio.testmovie.BR;

public class MovieModel extends BaseObservable {

    private String Title;
    private String Year;
    private String imdbID;
    private String Type;
    private String Poster;

    public MovieModel() {
    }

    public MovieModel(String title, String year, String imdbID, String type, String poster) {
        Title = title;
        Year = year;
        this.imdbID = imdbID;
        Type = type;
        Poster = poster;
    }

    @Bindable
    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }
    public String getType() {
        return Type;
    }
    public String getPoster(){ return Poster; }

    public MovieModel getMovie(){
        return this;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setTitle(String title) {
        this.Title = title;
        notifyPropertyChanged(BR.title);
    }




}
