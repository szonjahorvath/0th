package org.example.zerothweekworkshop.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String overview;
    private float popularity;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<UserPreferences> userPreferences;

}
