package com.example.movieservice.service;

import com.example.movieservice.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Service
public class MovieService {

    public List<Movie> db = new ArrayList<>();

    public List<Movie> getAllMovies() {
        return db;
    }

    public Movie getMovieById(Long id) {

        Optional<Movie> movie = db.stream().filter(m -> m.getId().equals(id)).findFirst();
        return movie.orElse(null);
    }

    public void saveMovie(Movie movie) {

        OptionalLong maxId = db.stream().mapToLong(Movie::getId).max();
        if (maxId.isPresent())
            movie.setId(maxId.getAsLong() + 1);
        else
            movie.setId(1L);
        db.add(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        Movie result = getMovieById(id);
        if (result != null) {
            result.setName(movie.getName());
            result.setCategory(movie.getCategory());
        }
        return result;
    }

    public Movie deleteMovie(Long id) {
        Movie movie = getMovieById(id);
        if (movie != null)
            db.remove(movie);
        return movie;
    }
}
