package com.efrei.webservice_spring_efrei.controller;

import com.efrei.webservice_spring_efrei.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloMovieController {

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/helloMovies")
    public ModelAndView getAllMovies() {
        ModelAndView mav = new ModelAndView("helloMovies");
        mav.addObject("movies", movieRepository.findAll());
        return mav;
    }
}
