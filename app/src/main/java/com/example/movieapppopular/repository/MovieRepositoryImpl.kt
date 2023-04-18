package com.example.movieapppopular.repository

import com.example.movieapppopular.data.model.MovieList
import com.example.movieapppopular.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(private val dataSource: RemoteMovieDataSource) : MovieRepository {

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()

    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()
}