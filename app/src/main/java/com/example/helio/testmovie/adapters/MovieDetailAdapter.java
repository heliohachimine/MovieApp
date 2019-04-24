package com.example.helio.testmovie.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helio.testmovie.R;
import com.example.helio.testmovie.databinding.MainLineViewBinding;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.model.MovieDetailModel;
import com.example.helio.testmovie.ui.model.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieDetailAdapter extends RecyclerView.Adapter<MovieDetailAdapter.MovieDetailViewHolder> {

    private MainLineViewBinding binding;
    private MovieRepository.Interator interator;

    private ArrayList<MovieDetailModel> mMovies = new ArrayList<>();

    public MovieDetailAdapter(MovieRepository.Interator interator) {
        this.interator = interator;
    }

    public void  updateFavoriteMovies(ArrayList<MovieDetailModel> movies){
        this.mMovies = movies;
        notifyDataSetChanged();
    }

    @Override
    public MovieDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieDetailAdapter.MovieDetailViewHolder vh = null;
        MainLineViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.main_line_view,parent, false);
        vh = new MovieDetailAdapter.MovieDetailViewHolder(binding,interator);
        return vh;
    }

    @Override
    public void onBindViewHolder(MovieDetailViewHolder holder, int position) {
        MovieDetailModel currentMovie = mMovies.get(position);
        holder.bind(currentMovie);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MovieDetailViewHolder extends RecyclerView.ViewHolder {
        private MainLineViewBinding binding;
        private MovieRepository.Interator interator;

        public MovieDetailViewHolder(MainLineViewBinding binding, MovieRepository.Interator interator) {
            super(binding.getRoot());
            this.binding = binding;
            this.interator = interator;
        }

        public void bind(final MovieDetailModel movie){
            if(!movie.getPoster().equals("N/A")){
                Picasso.get().load(movie.getPoster()).into(binding.ivPoster);
            }else{
                binding.ivPoster.setImageResource(R.drawable.defaultthumbnail);
            }

            binding.tvTitle.setText(movie.getTitle());
            binding.tvYear.setText(movie.getYear());
            binding.clMovie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    interator.onClickDetail(movie.getImdbID());
                }
            });

        }

    }
}
