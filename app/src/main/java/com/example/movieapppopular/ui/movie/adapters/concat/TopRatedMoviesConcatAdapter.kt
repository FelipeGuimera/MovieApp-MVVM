package com.example.movieapppopular.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapppopular.core.BaseConcatHolder
import com.example.movieapppopular.databinding.TopRatedMoviesRowBinding
import com.example.movieapppopular.ui.movie.adapters.MovieAdapterSmall

class TopRatedMoviesConcatAdapter(private val moviesAdapter: MovieAdapterSmall) : RecyclerView.Adapter<BaseConcatHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = TopRatedMoviesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder->holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: TopRatedMoviesRowBinding): BaseConcatHolder<MovieAdapterSmall>(binding.root){
        override fun bind(adapter: MovieAdapterSmall) {
            binding.rvTopRatedMovies.adapter = adapter
        }

    }

}