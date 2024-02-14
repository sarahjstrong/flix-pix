package com.techelevator.controller;

import com.techelevator.dao.GenreDao;

import com.techelevator.model.Genre;
import com.techelevator.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class GenreController {

    public GenreController(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Autowired

    private GenreDao genreDao;

    @RequestMapping(path = "/genres", method = RequestMethod.GET)
    public List<Genre> getGenres() {
        return genreDao.getGenres();
    }


   @RequestMapping(path="/genre/{id}", method = RequestMethod.GET)
    public Genre getGenre(@PathVariable int id){
        return genreDao.getGenreById(id);
    }
    @RequestMapping(path="/genre/name", method = RequestMethod.GET)
    public Genre getGenreByName(@RequestParam String name){
        return genreDao.getGenreByName(name);
    }
}

