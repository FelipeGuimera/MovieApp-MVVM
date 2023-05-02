package com.example.movieapppopular.repository

import com.example.movieapppopular.data.local.LocalMovieDataSource
import com.example.movieapppopular.data.model.MovieList
import com.example.movieapppopular.data.model.toMovieEntity
import com.example.movieapppopular.data.remote.RemoteMovieDataSource

class MovieRepositoryImpl(
    private val dataSourceRemote: RemoteMovieDataSource,
    private val dataSourceLocal: LocalMovieDataSource
) : MovieRepository {

    override suspend fun getPopularMovies(): MovieList{
        dataSourceRemote.getPopularMovies().results.forEach{movie->
            dataSourceLocal.saveMovie(movie.toMovieEntity("popular"))
        }
        return dataSourceLocal.getPopularMovies()
    }

    override suspend fun getTopRatedMovies(): MovieList{
        dataSourceRemote.getTopRatedMovies().results.forEach{movie->
            dataSourceLocal.saveMovie(movie.toMovieEntity("toprated"))
        }
        return dataSourceLocal.getTopRatedMovies()
    }

    override suspend fun getUpcomingMovies(): MovieList{
        dataSourceRemote.getUpcomingMovies().results.forEach{movie->
            dataSourceLocal.saveMovie(movie.toMovieEntity("upcoming"))
        }
        return dataSourceLocal.getUpcomingMovies()
    }
}