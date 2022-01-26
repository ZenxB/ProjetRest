package com.efrei.webservice_spring_efrei.controller;

import com.efrei.webservice_spring_efrei.exception.ResourceNotFoundException;
import com.efrei.webservice_spring_efrei.model.Movie;
import com.efrei.webservice_spring_efrei.model.Theatre;
import com.efrei.webservice_spring_efrei.repository.MovieRepository;
import com.efrei.webservice_spring_efrei.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/movies")

public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @GetMapping
    List<Movie> getMovies(){
        return movieRepository.findAll();
    }
    @PostMapping
    Movie createMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    @GetMapping("{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int movieId) {
        Movie movie = movieRepository.findById(movieId).get();
        return ResponseEntity.ok(movie);
    }

    @PutMapping("{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int movieId, @RequestBody Movie movieDetails) {
        Movie updateMovie = movieRepository.findById(movieId).get();
        updateMovie.setTitle(movieDetails.getTitle());
        updateMovie.setDuration(movieDetails.getDuration());
        updateMovie.setLanguage(movieDetails.getLanguage());
        updateMovie.setSubtitles(movieDetails.getSubtitles());
        updateMovie.setDirector(movieDetails.getDirector());
        updateMovie.setMainActors(movieDetails.getMainActors());
        updateMovie.setMinAge(movieDetails.getMinAge());
        updateMovie.setStartingDate(movieDetails.getStartingDate());
        updateMovie.setEndDate(movieDetails.getEndDate());

        movieRepository.save(updateMovie);
        return ResponseEntity.ok(updateMovie);
    }

    @DeleteMapping("{movieId}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable int movieId) {
        Movie movie = movieRepository.findById(movieId).get();
        movieRepository.delete(movie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{movieId}/theatres/{theatreId}")
    Movie addTheatreToMovie(
            @PathVariable int movieId,
            @PathVariable int theatreId
    ){
        Movie movie = movieRepository.findById(movieId).get();
        Theatre theatre = theatreRepository.findById(theatreId).get();
        movie.lesTheatres.add(theatre);
        return movieRepository.save(movie);
    }



}
