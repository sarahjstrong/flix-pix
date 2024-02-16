package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.MovieDao;
import com.techelevator.model.ImdbIdDto;
import com.techelevator.model.Movie;
import com.techelevator.model.MovieAPIDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import services.OMDBService;

import java.util.List;

@RestController
@CrossOrigin

public class MovieController {

@Autowired
    private MovieDao movieDao;
    OMDBService omdbService;


    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;}

    @RequestMapping(path = "/all-movies", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
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
            int genreId = 1;
            Double rating = jsonNode.path("imdbRating").asDouble();
            String director = jsonNode.path("Director").asText();
            String poster = jsonNode.path("Poster").asText();


            newMovie = new Movie(movieId,movieTitle, releaseYear, genreId, rating, director);

        } catch (JsonMappingException e) {

        } catch (JsonProcessingException e) {

        }
        return newMovie;
    }
}


