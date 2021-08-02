package com.example.movieservice.repository;

import com.example.movieservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Modifying
    @Transactional
    @Query("update Movie m set m.isAvailable = :isAvailable where m.id = :id")
    void updateMovieAvailability(boolean isAvailable, Long id);
}
