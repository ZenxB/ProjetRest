package com.efrei.webservice_spring_efrei.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_Id", nullable = false)
    private int movieId;

    @Column(name = "title", nullable=false)
    private String title;

    @Column(name = "duration",  nullable=false)
    private String duration;

    @Column(name = "language", nullable=false)
    private String language;

    @Column(name = "subtitles")
    private String subtitles;

    @Column(name = "director", nullable=false)
    private String director;

    //Or ArrayList of actors
    @Column(name = "main_actors", nullable=false)
    private String mainActors;

    @Column(name = "min_age", nullable=false)
    private Integer minAge;

    //Or Date
    @Column(name = "starting_date", nullable=false)
    private String startingDate;

    //Or Date
    @Column(name = "end_date", nullable=false)
    private String endDate;




    //Jointures
    @ManyToMany()
    @JoinTable(
            name="movies_theatres",
            joinColumns = @JoinColumn(name = "movie_Id"),
            inverseJoinColumns = @JoinColumn(name = "theatre_Id"))
    public Set<Theatre> lesTheatres= new HashSet<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "movie"
    )
    private Set<Session> sessions;

    public Set<Theatre> getLesTheatres() {
        return lesTheatres;
    }



}
