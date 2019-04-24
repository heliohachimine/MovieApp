package com.example.helio.testmovie.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helio.testmovie.R;

import com.example.helio.testmovie.databinding.MainLineViewBinding;
import com.example.helio.testmovie.repository.MovieRepository;
import com.example.helio.testmovie.ui.model.MovieModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private MovieRepository.Interator interator;

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private MainLineViewBinding binding;
        private MovieRepository.Interator interator;

        public MovieViewHolder(MainLineViewBinding binding, MovieRepository.Interator interator) {
            super(binding.getRoot());
            this.binding = binding;
            this.interator = interator;
        }

        public void bind(final MovieModel movie) {
            if (!movie.getPoster().equals("N/A")) {
                Picasso.get().load(movie.getPoster()).into(binding.ivPoster);
            } else {
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

    private ArrayList<MovieModel> mMovies = new ArrayList<>();

    public MovieAdapter(MovieRepository.Interator interator) {
        this.interator = interator;
    }

    public void updateMovies(ArrayList<MovieModel> movies) {

        this.mMovies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieViewHolder vh = null;
        MainLineViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.main_line_view, parent, false);
        vh = new MovieViewHolder(binding, interator);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModel currentMovie = mMovies.get(position);
        holder.bind(currentMovie);
    }

    @Override
    public int getItemCount() {
        return mMovies != null ? mMovies.size() : 0;
    }

}
