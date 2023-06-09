package com.example.movieapppopular.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.movieapppopular.R
import com.example.movieapppopular.core.Resource
import com.example.movieapppopular.data.local.AppDataBase
import com.example.movieapppopular.data.local.LocalMovieDataSource
import com.example.movieapppopular.data.model.Movie
import com.example.movieapppopular.data.remote.RemoteMovieDataSource
import com.example.movieapppopular.databinding.FragmentMovieBinding
import com.example.movieapppopular.presentation.MovieViewModel
import com.example.movieapppopular.presentation.MovieViewModelFactory
import com.example.movieapppopular.repository.MovieRepositoryImpl
import com.example.movieapppopular.repository.RetrofitClient
import com.example.movieapppopular.ui.movie.adapters.MovieAdapterMedium
import com.example.movieapppopular.ui.movie.adapters.MovieAdapterSmall
import com.example.movieapppopular.ui.movie.adapters.concat.PopularMoviesConcatAdapter
import com.example.movieapppopular.ui.movie.adapters.concat.TopRatedMoviesConcatAdapter
import com.example.movieapppopular.ui.movie.adapters.concat.UpcomingMoviesConcatAdapter



class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapterMedium.OnMovieClickListener {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(
            MovieRepositoryImpl(
                RemoteMovieDataSource(RetrofitClient.webservice),
                LocalMovieDataSource(AppDataBase.getDataBase(requireContext()).movieDao())
            )
        )
    }

    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(PopularMoviesConcatAdapter(MovieAdapterMedium(result.data.first.results, this@MovieFragment)))
                        addAdapter(TopRatedMoviesConcatAdapter(MovieAdapterSmall(result.data.second.results, this@MovieFragment)))
                        addAdapter(UpcomingMoviesConcatAdapter(MovieAdapterSmall(result.data.third.results, this@MovieFragment)))
                    }

                    binding.rvMovies.adapter = concatAdapter
                }

                is Resource.Failure -> {
                    Log.d("Error", "${result.exception}")
                }

            }
        })


    }

    override fun OnMovieClick(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailsFragment(
            movie.poster_path,
            movie.backdrop_path,
            movie.vote_average.toFloat(),
            movie.vote_count.toFloat().toInt(),
            movie.overview,
            movie.title,
            movie.original_language,
            movie.release_date
        )
        findNavController().navigate(action)
    }
}