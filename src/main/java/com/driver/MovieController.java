package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired //movieService object creation
    MovieService movieService;

    //add movie
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added", HttpStatus.CREATED);
    }

    //add director
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added", HttpStatus.CREATED);
    }

    //Pair an existing movie and director
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.addMovieDirectorPair(movie, director);
        return new ResponseEntity<>("New movie and new diretor pair added", HttpStatus.OK);
    }

    //Get Movie by movie name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String searchMovie){
         Movie movie = movieService.getMovieByName(searchMovie);
         return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    //Get Director by director name
    @GetMapping("/get-director-by-director-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String searchDirector){
       // Director director = null;
        Director director = movieService.getDirectorByName(searchDirector);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }

    //Get List of movies name for a given director name
    @GetMapping("/get-movie-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String searchDirector){
        List<String> movie = movieService.getMoviesByDirectorName(searchDirector);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    //Get List of all movies added
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> allMovie = movieService.findAllMovies();
        return new ResponseEntity<>(allMovie, HttpStatus.FOUND);
    }

    //Delete a director and its movies from the records
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String searchDirector){
           movieService.deleteDirectorByName(searchDirector);
           return new ResponseEntity<>(searchDirector + "The director has been deleted", HttpStatus.OK);
    }

    //Delete all directors and all movies by them from the records
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All Directors has been deleted", HttpStatus.OK);
    }
}
