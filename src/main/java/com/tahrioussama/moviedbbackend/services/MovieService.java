package com.tahrioussama.moviedbbackend.services;

import com.tahrioussama.moviedbbackend.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> allMovies();
    Optional<Movie> findMovieByImdbId(String imdbId);
}
