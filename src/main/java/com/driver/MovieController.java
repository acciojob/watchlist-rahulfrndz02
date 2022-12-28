package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MovieController {

    @Autowired //movieService object creation
    MovieService movieService;

    //add movie
    @PostMapping("movie/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //add director
    @PostMapping("director/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        String response = movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Pair an existing movie and director
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<Pair> addMovieDirectorPair(@RequestBody() Movie movie, @RequestBody Director director){
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movie, director),HttpStatus.OK);
    }

    //Get Movie by movie name
    @GetMapping("/get-movie-by-movie-name/{name}")
    public ResponseEntity<Movie> getMovie(@RequestParam("name") Movie movie){
        return null;
    }

    //Get Director by director name

    //Get List of movies name for a given director name

    //Get List of all movies added
    @GetMapping("/get-all-movies")
    public ResponseEntity<Movie> findAllMovies(){
        Movie allMovie = movieService.findAllMovies();
        if(allMovie==null){
            return new ResponseEntity<>(resultStudent,HttpStatus.BAD_REQUEST);
        }
        else
            return new ResponseEntity<>(resultStudent,HttpStatus.OK);
    }

    //Delete a director and its movies from the records

    //Delete all directors and all movies by them from the records

}
