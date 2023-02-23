package com.shanesmith.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shanesmith.models.Movie;
import com.shanesmith.models.MovieDocs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TheOneService {

    @Value("${LOTR_API}")
    private String LOTR_API;
    @Value("${KEY}")
    private String KEY;

    RestTemplate restTemplate = new RestTemplate();
    public List<Movie> getAllMovies() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(KEY);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        ResponseEntity<String> responseEntity = restTemplate.exchange(LOTR_API + "/movie", HttpMethod.GET, entity, String.class);

        List<Movie> movieList = new ArrayList<>();

        try {
            jsonNode = mapper.readTree(responseEntity.getBody());
            JsonNode docs = jsonNode.path("docs");
            for (int i = 0; i < docs.size(); i++) {
                Movie tempMovie = new Movie();
                String movieId = docs.path(i).path("_id").asText();
                tempMovie.setTheOneMovieId(movieId);
                String movieName = docs.path(i).path("name").asText();
                tempMovie.setName(movieName);
                int runTime = docs.path(i).path("runtimeInMinutes").asInt();
                tempMovie.setRuntimeInMinutes(runTime);
                int budget = docs.path(i).path("budgetInMillions").asInt();
                tempMovie.setBudgetInMillions(budget);
                movieList.add(tempMovie);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    public List<Movie> loadAllMovies() {
        ResponseEntity<MovieDocs> responseEntity = restTemplate.exchange(LOTR_API + "/movie", HttpMethod.GET, makeEntity(), MovieDocs.class);
        MovieDocs movieDocs = responseEntity.getBody();
        Movie[] movies = movieDocs.getMovies();
        return Arrays.asList(movies);
    }

    private HttpEntity<Void> makeEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(KEY);

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        return entity;
    }
}
