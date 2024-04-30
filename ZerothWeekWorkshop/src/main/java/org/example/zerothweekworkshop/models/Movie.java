package org.example.zerothweekworkshop.models;

import lombok.Data;

@Data
public class Movie {

    private int id;
    private String title;
    private String overview;
    private float popularity;

//    public Movie(int id, String title, String overview, float popularity) {
//        this.id = id;
//        this.title = title;
//        this.overview = overview;
//        this.popularity = popularity;
//
//    }
}
