package org.example.zerothweekworkshop.services;

import org.example.zerothweekworkshop.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;

@Service
public class MovieService {

    private final TMDBClient tmdbClient;

    @Autowired
    public MovieService(Retrofit retrofit) {
        this.tmdbClient = retrofit.create(TMDBClient.class);
    }

    public Call<MovieDTO> getPopularMovies(String apiKey) {
        return tmdbClient.getPopularMovies(apiKey);
    }
}
