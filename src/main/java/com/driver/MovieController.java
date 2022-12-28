package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired //movieService object creation
    MovieService movieService;

    //add movie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String response = movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //add director
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        return null;
    }

    //Pair an existing movie and director

    //Get Movie by movie name
    @GetMapping("/get-movie-by-movie-name/{name}")
    public ResponseEntity<Movie> getMovie(@RequestParam("name") Movie movie){
        return null;
    }

    //Get Director by director name

    //Get List of movies name for a given director name

    //Get List of all movies added

    //Delete a director and its movies from the records

    //Delete all directors and all movies by them from the records

}
