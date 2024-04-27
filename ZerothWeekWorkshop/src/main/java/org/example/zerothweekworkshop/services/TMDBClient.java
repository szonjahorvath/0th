package org.example.zerothweekworkshop.services;

import org.example.zerothweekworkshop.dto.MovieDTO;
import org.example.zerothweekworkshop.models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBClient {

    @GET("movie/{id}")
    Call<Movie> getMovieDetails(@Path("id") int movieId);

    @GET("movie/popular")
    Call<MovieDTO> getPopularMovies(@Query("api_key") String apiKey);
}
