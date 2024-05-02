package org.example.zerothweekworkshop.services;

import org.example.zerothweekworkshop.dto.MovieDTO;
import org.example.zerothweekworkshop.models.Movie;
import org.example.zerothweekworkshop.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final TMDBClient tmdbClient;
    private List<Movie> movieList = new ArrayList<>();

    @Autowired
    MoviesRepository movieRepository;

    @Autowired
    public MovieService(Retrofit retrofit) {
        this.tmdbClient = retrofit.create(TMDBClient.class);
    }

    public Call<MovieDTO> getPopularMovies(String apiKey) {
        return tmdbClient.getPopularMovies(apiKey);
    }

    public void setMovieList(List<Movie> movies) {
        this.movieList = movies;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void saveMovie(Movie movie) {
        Movie preferredMovie = new Movie();
        preferredMovie.setTitle(movie.getTitle());
        preferredMovie.setPopularity(movie.getPopularity());
    //    preferredMovie.setOverview(movie.getOverview());
        movieRepository.save(preferredMovie);
    }

    public void saveAllMovies(List<Movie> results) {
        movieList = results;
        movieRepository.saveAll(movieList);
    }

    public Optional<Movie> findMovieById(Long id){
       return movieRepository.findById(id);
    }
}
