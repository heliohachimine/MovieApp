package com.example.helio.testmovie.ui.activity;

import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.helio.testmovie.R;
import com.example.helio.testmovie.data.DBHelper;
import com.example.helio.testmovie.data.DBMovie;
import com.example.helio.testmovie.data.DBMovieException;
import com.example.helio.testmovie.databinding.ActivityDetailBinding;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.model.MovieDetailModel;
import com.example.helio.testmovie.ui.model.MovieModel;
import com.example.helio.testmovie.viewmodel.DetailViewModel;
import com.example.helio.testmovie.viewmodel.MainViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements MovieRepository.Interator {

    ActivityDetailBinding binding;
    private DetailViewModel viewModel;
    private SQLiteDatabase movieDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new DetailViewModel(this, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setVm(viewModel);
        binding.executePendingBindings();

        viewModel.loadMovie(getIntent().getStringExtra("IMDBID"));
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
        viewModel.setMovie(movie);
        Picasso.get().load(movie.getPoster()).into(binding.ivPoster);
        binding.executePendingBindings();
    }

    @Override
    public void onErrorResult() {

    }


}
