package org.example.zerothweekworkshop.controllers;

import org.example.zerothweekworkshop.dto.MovieDTO;
import org.example.zerothweekworkshop.services.MovieService;
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

@RestController
@RequestMapping("/user/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

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
                    model.addAttribute("movies", response.body().getResults());  // added line
        // earlier solution: deferredResult.setResult(ResponseEntity.ok(response.body().getResults()));
                    deferredResult.setResult(ResponseEntity.ok("popularMovies"));
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
}