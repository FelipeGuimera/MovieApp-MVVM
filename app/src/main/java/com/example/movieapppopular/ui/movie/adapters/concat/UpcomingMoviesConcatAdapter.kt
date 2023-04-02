package com.example.movieapppopular.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapppopular.core.BaseConcatHolder
import com.example.movieapppopular.databinding.UpcomingMoviesRowBinding
import com.example.movieapppopular.ui.movie.adapters.MovieAdapterSmall

class UpcomingMoviesConcatAdapter (private val moviesAdapter: MovieAdapterSmall) : RecyclerView.Adapter<BaseConcatHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = UpcomingMoviesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder->holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: UpcomingMoviesRowBinding): BaseConcatHolder<MovieAdapterSmall>(binding.root){
        override fun bind(adapter: MovieAdapterSmall) {
            binding.rvUpcomingMovies.adapter = adapter
        }

    }

}