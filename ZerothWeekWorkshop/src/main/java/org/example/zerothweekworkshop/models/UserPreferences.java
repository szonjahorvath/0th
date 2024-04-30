package org.example.zerothweekworkshop.models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`user_preferences`")
public class UserPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String overview;
    private float popularity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
