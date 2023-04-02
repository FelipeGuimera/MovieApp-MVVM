package com.example.movieapppopular.repository

import com.example.movieapppopular.data.model.MovieList

interface MovieRepository {
   suspend fun getPopularMovies (): MovieList

   suspend fun getTopRatedMovies (): MovieList

   suspend fun getUpcomingMovies (): MovieList
}