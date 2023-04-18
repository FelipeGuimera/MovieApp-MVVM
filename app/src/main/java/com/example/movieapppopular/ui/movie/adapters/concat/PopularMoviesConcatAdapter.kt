package com.example.movieapppopular.ui.movie.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapppopular.core.BaseConcatHolder
import com.example.movieapppopular.databinding.PopularMoviesRowBinding
import com.example.movieapppopular.ui.movie.adapters.MovieAdapterMedium

class PopularMoviesConcatAdapter(private val moviesAdapter: MovieAdapterMedium) : RecyclerView.Adapter<BaseConcatHolder<*>>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = PopularMoviesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder->holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: PopularMoviesRowBinding): BaseConcatHolder<MovieAdapterMedium>(binding.root){
        override fun bind(adapter: MovieAdapterMedium) {
            binding.rvPopularMovies.adapter = adapter
        }

    }

}