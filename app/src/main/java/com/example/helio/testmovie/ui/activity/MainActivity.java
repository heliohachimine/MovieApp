package com.example.helio.testmovie.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.example.helio.testmovie.R;
import com.example.helio.testmovie.adapters.MovieAdapter;
import com.example.helio.testmovie.adapters.MovieDetailAdapter;
import com.example.helio.testmovie.adapters.PagerAdapter;
import com.example.helio.testmovie.databinding.ActivityMainBinding;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.model.MovieDetailModel;
import com.example.helio.testmovie.ui.model.MovieModel;
import com.example.helio.testmovie.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieRepository.Interator {
    private MovieAdapter mAdapter;
    private MovieDetailAdapter mdAdapter;

    private MainViewModel viewModel;

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        viewModel = new MainViewModel(this);
        viewModel.interator = this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setVm(viewModel);
        binding.executePendingBindings();

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Inicio"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Favoritos"));
        binding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), binding.tabLayout.getTabCount());
        binding.pager.setAdapter(adapter);
        binding.pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout));
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    @Override
    public void updateMovies(ArrayList<MovieModel> movies) {
        mAdapter.notifyDataSetChanged();
        mAdapter.updateMovies(movies);

    }

    @Override
    public void updateFavoriteMovies(ArrayList<MovieDetailModel> movies) {
        mAdapter.notifyDataSetChanged();
        mdAdapter.updateFavoriteMovies(movies);
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
