package com.example.movieapppopular.repository

import com.example.movieapppopular.data.local.LocalMovieDataSource
import com.example.movieapppopular.data.model.MovieList
import com.example.movieapppopular.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {

    override suspend fun getPopularMovies(): MovieList = dataSourceRemote.getPopularMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSourceRemote.getTopRatedMovies()

    override suspend fun getUpcomingMovies(): MovieList = dataSourceRemote.getUpcomingMovies()
}