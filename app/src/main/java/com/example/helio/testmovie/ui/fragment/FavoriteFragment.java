package com.example.helio.testmovie.ui.fragment;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helio.testmovie.adapters.MovieAdapter;
import com.example.helio.testmovie.adapters.MovieDetailAdapter;
import com.example.helio.testmovie.data.DBHelper;
import com.example.helio.testmovie.data.DBMovie;
import com.example.helio.testmovie.data.DBMovieException;
import com.example.helio.testmovie.databinding.FragmentFavoriteBinding;
import com.example.helio.testmovie.repository.BDRepository;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.model.MovieDetailModel;
import com.example.helio.testmovie.ui.model.MovieModel;
import com.example.helio.testmovie.viewmodel.MainViewModel;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment  implements MovieRepository.Interator {

    private SQLiteDatabase movieDB;
    private MovieDetailAdapter mAdapter;
    private MainViewModel viewModel;
    private FragmentFavoriteBinding binding;
    private BDRepository repository = new BDRepository();
    private ArrayList<MovieDetailModel> movies = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        mAdapter = new MovieDetailAdapter(this);
        viewModel = new MainViewModel(getContext());
        viewModel.interator = this;
        binding = FragmentFavoriteBinding.inflate(inflater, container,false);
        binding.setVm(viewModel);
        setupRecycler();
        binding.executePendingBindings();

        this.movies = repository.getAllMovies(inflater.getContext());



        return binding.getRoot();
    }


    private void setupRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.rvMovies.setLayoutManager(layoutManager);
        binding.rvMovies.setHasFixedSize(true);
        binding.rvMovies.setAdapter(mAdapter);

    }



    @Override
    public void updateMovies(ArrayList<MovieModel> movies) {

    }

    @Override
    public void updateFavoriteMovies(ArrayList<MovieDetailModel> movies) {
            mAdapter.updateFavoriteMovies(movies);
    }


    @Override
    public void onClickDetail(String imdbId) {

    }

    @Override
    public void loadDetailsMovie(MovieDetailModel movie) {

    }

    @Override
    public void onErrorResult() {

    }
}
