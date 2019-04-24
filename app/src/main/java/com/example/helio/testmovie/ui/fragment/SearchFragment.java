package com.example.helio.testmovie.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helio.testmovie.adapters.MovieAdapter;
import com.example.helio.testmovie.databinding.FragmentSearchBinding;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.activity.DetailActivity;
import com.example.helio.testmovie.ui.model.MovieDetailModel;
import com.example.helio.testmovie.ui.model.MovieModel;
import com.example.helio.testmovie.viewmodel.MainViewModel;


import java.util.ArrayList;

public class SearchFragment extends Fragment implements MovieRepository.Interator {

    private MovieAdapter mAdapter;
    private MainViewModel viewModel;
    private FragmentSearchBinding binding;

    public SearchFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        mAdapter = new MovieAdapter(this);
        viewModel = new MainViewModel(getContext());
        viewModel.interator = this;
        binding = FragmentSearchBinding.inflate(inflater, container,false);
        binding.setVm(viewModel);
        setupRecycler();

        binding.executePendingBindings();


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
        mAdapter.updateMovies(movies);
    }

    @Override
    public void updateFavoriteMovies(ArrayList<MovieDetailModel> movies) {

    }

    @Override
    public void onClickDetail(String imdbId) {
        Log.d("ID",imdbId );
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("IMDBID",imdbId);
        startActivity(intent);

    }

    @Override
    public void loadDetailsMovie(MovieDetailModel movie) {

    }

    @Override
    public void onErrorResult() {

    }


}
