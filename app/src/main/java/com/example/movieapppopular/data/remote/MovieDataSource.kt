package com.example.movieapppopular.data.remote

import com.example.movieapppopular.application.AppConstants
import com.example.movieapppopular.data.model.MovieList
import com.example.movieapppopular.repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getUpcomingMovies(): MovieList = webService.getUpcomingMovies(AppConstants.API_KEY)
}
