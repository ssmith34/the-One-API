package com.shanesmith.controllers;

import com.shanesmith.models.Movie;
import com.shanesmith.services.TheOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class TheOneController {

    @Autowired
    TheOneService service;

    @GetMapping("/movies")
    public List<Movie> getAllMoviesFromApi() {
        return service.getAllMovies();
    }
}
