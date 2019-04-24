package com.example.helio.testmovie.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.helio.testmovie.R;
import com.example.helio.testmovie.adapters.MovieAdapter;
import com.example.helio.testmovie.databinding.ActivityMainBinding;
import com.example.helio.testmovie.databinding.ActivityTesteBinding;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.model.MovieDetailModel;
import com.example.helio.testmovie.ui.model.MovieModel;
import com.example.helio.testmovie.viewmodel.MainViewModel;

import java.util.ArrayList;

public class TesteActivity extends AppCompatActivity implements MovieRepository.Interator {

    private MovieAdapter mAdapter;
    private ActivityTesteBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new MovieAdapter(this);
        viewModel = new MainViewModel(this);
        viewModel.interator = this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teste);
        binding.setVm(viewModel);
        setupRecycler();
        binding.executePendingBindings();

    }
    private void setupRecycler(){
        binding.rvMovies.setAdapter(mAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvMovies.setLayoutManager(layoutManager);
        binding.rvMovies.setHasFixedSize(true);
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

    }

    @Override
    public void loadDetailsMovie(MovieDetailModel movie) {

    }

    @Override
    public void onErrorResult() {

    }
}
