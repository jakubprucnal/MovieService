package com.example.movieservice.service;

import com.example.movieservice.model.Movie;
import com.example.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Service
public class MovieService {

     private final MovieRepository movieRepository;

//    public List<Movie> db = new ArrayList<>();

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        Optional<Movie> result = movieRepository.findById(id);
        return result.get();
    }

    public void saveMovie(Movie movie) {

        movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        Movie result = getMovieById(id);
        if (result != null) {
            result.setName(movie.getName());
            result.setCategory(movie.getCategory());
        }
        movieRepository.save(result);
        return result;
    }

    public Boolean deleteMovie(Long id) {
        Boolean result = movieRepository.existsById(id);
        if (result)
            movieRepository.deleteById(id);
        return result;
    }
}
