package com.example.movieapppopular.repository

import com.example.movieapppopular.data.model.MovieList
import com.example.movieapppopular.data.remote.MovieDataSource

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()

}