package com.tahrioussama.moviedbbackend.services;

import com.tahrioussama.moviedbbackend.entities.Movie;
import com.tahrioussama.moviedbbackend.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Override
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
