package com.efrei.webservice_spring_efrei.controller;

import com.efrei.webservice_spring_efrei.model.Movie;
import com.efrei.webservice_spring_efrei.model.Theatre;
import com.efrei.webservice_spring_efrei.repository.MovieRepository;
import com.efrei.webservice_spring_efrei.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {


    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    MovieRepository movieRepository;


    @GetMapping
    List<Theatre> getTheatres(){
        return theatreRepository.findAll();
    }

    @PostMapping
    Theatre createTheatre(@RequestBody Theatre theatre){
        return theatreRepository.save(theatre);
    }

    @GetMapping("{theatreId}")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable int theatreId) {
        Theatre city = theatreRepository.findById(theatreId).get();
        return ResponseEntity.ok(city);
    }

    @PutMapping("{id}")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable int theatreId, @RequestBody Theatre theatreDetails) {
        Theatre updateTheatre = theatreRepository.findById(theatreId).get();
        updateTheatre.setName(theatreDetails.getName());
        updateTheatre.setAddress(theatreDetails.getAddress());
        updateTheatre.setCity(theatreDetails.getCity());
        theatreRepository.save(updateTheatre);
        return ResponseEntity.ok(updateTheatre);
    }

    @DeleteMapping("{theatreId}")
    public ResponseEntity<HttpStatus> deleteTheatre(@PathVariable int theatreId) {
        Theatre theatre = theatreRepository.findById(theatreId).get();
        theatreRepository.delete(theatre);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
