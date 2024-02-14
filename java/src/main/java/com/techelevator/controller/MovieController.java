package com.techelevator.controller;

import com.techelevator.dao.MovieDao;
import com.techelevator.model.ImdbIdDto;
import com.techelevator.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class MovieController {

@Autowired
    private MovieDao movieDao;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;}

    @RequestMapping(path = "/all-movies", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @ResponseStatus(code = HttpStatus.CREATED, reason = "Successfully added movie to database")
    @PostMapping(path = "api/movies/call_api")
    public int addMovieFromAPI(@RequestBody ImdbIdDto imdbId) {
        int returnedId = movieDao.addMovieFromAPI(imdbId.getImdbId());
        return returnedId;
    }

}


