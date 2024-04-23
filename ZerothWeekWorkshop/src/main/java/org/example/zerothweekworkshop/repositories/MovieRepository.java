package org.example.zerothweekworkshop.repositories;

import org.example.zerothweekworkshop.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
