package com.example.helio.testmovie.ui.activity;

import android.arch.lifecycle.Observer;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.helio.testmovie.R;
import com.example.helio.testmovie.data.DBHelper;
import com.example.helio.testmovie.databinding.ActivityDetailBinding;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.model.MovieDetailModel;
import com.example.helio.testmovie.ui.model.MovieModel;
import com.example.helio.testmovie.viewmodel.DetailViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements MovieRepository.Interator {

    ActivityDetailBinding binding;
    private DetailViewModel viewModel;
    private SQLiteDatabase movieDB;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new DetailViewModel(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setVm(viewModel);
        binding.executePendingBindings();
        viewModel.loadMovie(getIntent().getStringExtra("IMDBID")).observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    binding.loadingLayout.setVisibility(View.VISIBLE);
                } else {
                    binding.loadingLayout.setVisibility(View.INVISIBLE);
                }
            }
        });
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
    }


    @Override
    protected void onResume() {
        super.onResume();
        DBHelper dbHelper = new DBHelper(this);
        movieDB = dbHelper.getWritableDatabase();

    }

    @Override
    public void updateMovies(ArrayList<MovieModel> movies) {

    }

    @Override
    public void updateFavoriteMovies(ArrayList<MovieDetailModel> movies) {

    }

    @Override
    public void onClickDetail(String imdbId) {

    }

    @Override
    public void loadDetailsMovie(MovieDetailModel movie) {
        binding.ivPoster.startAnimation(animation);
        viewModel.setMovie(movie);
        Picasso.get().load(movie.getPoster()).into(binding.ivPoster);
        binding.executePendingBindings();

    }

    @Override
    public void onErrorResult() {

    }


}
