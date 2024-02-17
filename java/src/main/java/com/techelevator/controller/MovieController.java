package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.MovieDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import services.OMDBService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class MovieController {

@Autowired
    private MovieDao movieDao;
    OMDBService omdbService;


    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;}

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path= "/movies", method = RequestMethod.POST)
    public Movie addMovie(@Valid @RequestBody Movie movie) {
        Movie addedMovie = movieDao.addMovie(movie);
        if (addedMovie == null) {
            throw new DaoException("Error adding movie");
        } else {
            return addedMovie;
        }
    }
    @RequestMapping(path = "/api/all-movies", method = RequestMethod.GET)
    public List<ApiMovie> getAllMovies(@RequestParam(defaultValue = "1") int page) {
        String url = "http://omdbapi.com/";
        String apiUrl =  url + "?apikey=" + "bac84920&t=" + "&s=movie&page=" + page;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ApiSearch> responseEntity = restTemplate.getForEntity(apiUrl, ApiSearch.class);


        return responseEntity.getBody().getSearch();

    }



//    @ResponseStatus(code = HttpStatus.CREATED, reason = "Successfully added movie to database")
//    @PostMapping(path = "api/movies/call_api")
//    public int addMovieFromAPI(@RequestBody ImdbIdDto imdbId) {
//        int returnedId = movieDao.addMovieFromAPI(imdbId.getImdbId());
//        return returnedId;
//    }
//
//    @RequestMapping(path="/test", method=RequestMethod.GET)
//    public List<Movie> getNewAPIMovie(@RequestParam String query) {
//        return omdbService.OMDBAPICall(query);
//    }


    @RequestMapping(path = "/movie/{id}", method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable int id) {
        return movieDao.getMovieById(id);
    }

    @RequestMapping(path = "/movie/{name}", method = RequestMethod.GET)
    public Movie getMovieByName(@PathVariable String name) {
        return movieDao.getMovieByName(name);
    }

    @RequestMapping(path = "/movies-by-genre/{genre}", method = RequestMethod.GET)
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieDao.getMoviesByGenre(genre);
    }

    @RequestMapping(path = "/movies-by-rating/{rating}", method = RequestMethod.GET)
    public List<Movie> getMoviesByRating(@PathVariable String rating) {
        return movieDao.getMoviesByRating(rating);
    }


    // - spaces
    @GetMapping("/api/{title}")
    public Movie test(@PathVariable("title") String title, Model model) {
        String url = "http://omdbapi.com/";
        String apiUrl = url + "?&apikey=bac84920&t={title}";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class, title);
        String movie = responseEntity.getBody();
        Movie newMovie = null;
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode;
            jsonNode = objectMapper.readTree(responseEntity.getBody());

            int movieId = 1;
            String movieTitle = jsonNode.path("Title").asText();
            int releaseYear = jsonNode.path("Year").asInt();
            String genre = jsonNode.path("Genre").asText();
            Double rating = jsonNode.path("imdbRating").asDouble();
            String director = jsonNode.path("Director").asText();
            String poster = jsonNode.path("Poster").asText();
            String plot = jsonNode.path("Plot").asText();


            newMovie = new Movie(movieId,movieTitle, releaseYear, genre, rating, director, poster, plot);

        } catch (JsonMappingException e) {

        } catch (JsonProcessingException e) {

        }
        return newMovie;
    }
}


