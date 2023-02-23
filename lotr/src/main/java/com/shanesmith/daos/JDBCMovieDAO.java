package com.shanesmith.daos;

import com.shanesmith.models.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JDBCMovieDAO implements MovieDAO {
    private JdbcTemplate jdbcTemplate;

    public JDBCMovieDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Movie addNewMovie(Movie movie) {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> movieList = new ArrayList<>();
        String sql = "SELECT * FROM movie";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            movieList.add(mapRowToMovie(results));
        }
        return movieList;
    }

    private Movie mapRowToMovie(SqlRowSet results) {
        Movie movie = new Movie();
        movie.setMovieId(results.getInt("id"));
        movie.setTheOneMovieId(results.getString("the_one_movie_id"));
        movie.setName(results.getString("name"));
        movie.setRuntimeInMinutes(results.getInt("runtime_in_minutes"));
        movie.setBudgetInMillions(results.getInt("budget_in_millions"));
        return movie;
    }
}
