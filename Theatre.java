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
@Table(name = "theatres")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_Id", updatable = false, nullable = false)
    private int theatreId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable=false)
    private String address;

    @Column(name = "city", nullable=false)
    private String city;



    //Jointures
    @JsonIgnore
    @ManyToMany(mappedBy = "lesTheatres")
    public Set<Movie> lesMovies = new HashSet<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "theatre"
    )
    private Set<Session> mysessions = new HashSet<>();

}
