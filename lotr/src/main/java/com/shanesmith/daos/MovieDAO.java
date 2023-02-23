package com.shanesmith.daos;

import com.shanesmith.models.Movie;

import java.util.List;

public interface MovieDAO {
    Movie addNewMovie(Movie movie);
    List<Movie> getAllMovies();

}
