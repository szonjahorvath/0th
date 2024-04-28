package org.example.zerothweekworkshop.dto;

import lombok.Data;
import org.example.zerothweekworkshop.models.Movie;

import java.util.List;

@Data
public class MovieDTO {

    private int page;
    private List<Movie> results;
    private int totalPages;
    private int totalResults;
}
