package com.efrei.webservice_spring_efrei.controller;

import com.efrei.webservice_spring_efrei.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloTheatreController {

    @Autowired
    MovieRepository theatreRepository;


    @GetMapping("/helloTheatres")
    public ModelAndView getAllTheatres() {
        ModelAndView mav = new ModelAndView("helloTheatres");
        mav.addObject("theatres", theatreRepository.findAll());
        return mav;
    }
}
