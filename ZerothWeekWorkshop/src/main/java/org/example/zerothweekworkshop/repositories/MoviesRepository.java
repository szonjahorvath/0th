package org.example.zerothweekworkshop.repositories;

import org.example.zerothweekworkshop.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MoviesRepository extends JpaRepository<Movie, Long> {
}
