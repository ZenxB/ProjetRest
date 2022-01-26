package com.efrei.webservice_spring_efrei.controller;

import com.efrei.webservice_spring_efrei.model.Movie;
import com.efrei.webservice_spring_efrei.model.Session;
import com.efrei.webservice_spring_efrei.model.Theatre;
import com.efrei.webservice_spring_efrei.repository.MovieRepository;
import com.efrei.webservice_spring_efrei.repository.SessionRepository;
import com.efrei.webservice_spring_efrei.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @GetMapping
    List<Session> getSessions(){
        return sessionRepository.findAll();
    }
    @PostMapping
    Session createSession(@RequestBody Session session){
        return sessionRepository.save(session);
    }

    @GetMapping("{sessionId}")
    public ResponseEntity<Session> getSessionById(@PathVariable int sessionId) {
        Session session = sessionRepository.findById(sessionId).get();
        return ResponseEntity.ok(session);
    }

    @PutMapping("/{sessionId}/movies/{movieId}/theatres/{theatreId}")
    Session addMovieandTheatreToSession(
            @PathVariable int sessionId,
            @PathVariable int movieId,
            @PathVariable int theatreId
    ){
        Session session = sessionRepository.findById(sessionId).get();
        Movie movie = movieRepository.findById(movieId).get();
        Theatre theatre = theatreRepository.findById(theatreId).get();
        session.addtheatre(theatre);
        session.addmovie(movie);
        return sessionRepository.save(session);
    }


}
