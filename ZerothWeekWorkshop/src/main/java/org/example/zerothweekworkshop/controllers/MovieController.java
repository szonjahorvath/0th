package org.example.zerothweekworkshop.controllers;

import org.example.zerothweekworkshop.dto.MovieDTO;
import org.example.zerothweekworkshop.models.Movie;
import org.example.zerothweekworkshop.services.MovieService;
import org.example.zerothweekworkshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

@RestController
@RequestMapping("/user/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Value("${tmdb.api.key}")
    private String apiKey;

    @GetMapping("/popular")
    public DeferredResult<ResponseEntity<?>> getPopularMovies(Model model) {
        DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();

        Call<MovieDTO> call = movieService.getPopularMovies(apiKey);
        call.enqueue(new Callback<MovieDTO>() {
            @Override
            public void onResponse(Call<MovieDTO> call, Response<MovieDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Process the data received from the API
                    MovieDTO movieDTO = response.body();
                    // Assuming you have a method to process and store the data
                    processAndStoreMovies(movieDTO.getResults());
                    deferredResult.setResult(ResponseEntity.ok(response.body().getResults()));
                } else {
                    deferredResult.setErrorResult(ResponseEntity.status(response.code()).body("Failed to fetch data with code: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<MovieDTO> call, Throwable throwable) {
                deferredResult.setErrorResult(ResponseEntity.internalServerError().body("API call failed: " + throwable.getMessage()));
            }
        });

        return deferredResult;
    }

    // Method to process and store movies in MovieService
    private void processAndStoreMovies(List<Movie> movies) {
        userService.saveMovies(movies);
    }
}