package com.example.cs5200f19serverjava.controllers;

import com.example.cs5200f19serverjava.daos.MovieDao;
import com.example.cs5200f19serverjava.models.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @PutMapping("/api/movies/{id}")
    public void updateMovie(
            @PathVariable("id") int id,
            @RequestBody Movie newMovie
            ) {
        MovieDao dao = MovieDao.getInstance();
        dao.pupdateMovie(id, newMovie);
    }
    @DeleteMapping("/api/movies/{id}")
    public void deleteMovie(@PathVariable("id") int id) {
        MovieDao dao = MovieDao.getInstance();
        dao.deleteMovie(id);
    }
    @PostMapping("/api/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        MovieDao dao = MovieDao.getInstance();
        dao.createMovie(movie);
        return movie;
    }
    @GetMapping("/api/movies/{id}")
    public Movie findMovieById(@PathVariable("id") int id) {
        MovieDao dao = MovieDao.getInstance();
        return dao.findMovieById(id);
    }
    @GetMapping("/api/movies")
    public List<Movie> findAllMovies() {
        MovieDao dao = MovieDao.getInstance();
        return dao.findAllMovies();
    }
}
