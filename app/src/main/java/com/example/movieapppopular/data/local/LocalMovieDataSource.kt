package com.example.movieapppopular.data.local

import com.example.movieapppopular.data.model.MovieEntity
import com.example.movieapppopular.data.model.MovieList
import com.example.movieapppopular.data.model.toMovieList


class LocalMovieDataSource(private val movieDao: MovieDao) {

    suspend fun getPopularMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type=="popular" }.toMovieList()
    }

    suspend fun getTopRatedMovies(): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type=="toprated" }.toMovieList()
    }

    suspend fun getUpcomingMovies(): MovieList{
        return movieDao.getAllMovies().filter { it.movie_type=="upcoming" }.toMovieList()
    }

    suspend fun saveMovie(movie: MovieEntity){
        movieDao.saveMovie(movie)
    }

}