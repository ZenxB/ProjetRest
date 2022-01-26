package com.efrei.webservice_spring_efrei.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id", updatable = false, nullable = false)
    private int sessionId;

    //Or Date
    @Column(name = "starting_time")
    private String startingTime;

    @Column(name = "days")
    private String days;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id", referencedColumnName = "theatre_id")
    private Theatre theatre;

    public void addtheatre (Theatre theatre){
        this.theatre= theatre;
    }


    public void addmovie(Movie movie) {
        this.movie=movie;
    }
}
