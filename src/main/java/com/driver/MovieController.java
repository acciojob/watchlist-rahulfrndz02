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
    public ResponseEntity<Pair> addMovieDirectorPair(@RequestBody() Pair pair){
        return new ResponseEntity<>(movieService.addMovieDirectorPair(pair), HttpStatus.OK);
    }

    //Get Movie by movie name
    @GetMapping("/get-movie-by-movie-name/{name}")
    public ResponseEntity<Movie> getMovie(@RequestParam("name") String searchMovie){
        //Movie movie = null;
         Movie movie = movieService.getMovieByMovieName(searchMovie);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    //Get Director by director name
    @GetMapping("/get-director-by-director-name/{name}")
    public ResponseEntity<Director> getDirectorByDirectorName(@RequestParam("name") String searchDirector){
       // Director director = null;
        Director director = movieService.getDirectorByDirectorName(searchDirector);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }

    //Get List of movies name for a given director name
    @GetMapping("/get-movie-by-director-name/{name}")
    public ResponseEntity<Movie> getMovieByDirectorName(@RequestParam("name") String searchDirector){
        Movie movie = null;
        movie = movieService.getMovieByDirectorName(searchDirector);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    //Get List of all movies added
    @GetMapping("/get-all-movies")
    public ResponseEntity<Movie> findAllMovies(){
        Movie allMovie = movieService.findAllMovies();
        if(allMovie==null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else
            return new ResponseEntity<>(allMovie,HttpStatus.OK);
    }

    //Delete a director and its movies from the records
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String searchDirector){
           this.movieService.deleteDirectorByName(searchDirector);
           return new ResponseEntity<>("The director has been deleted", HttpStatus.OK);

    }

    //Delete all directors and all movies by them from the records
    public ResponseEntity<Director> deleteAllDirectors(){
        Director d = movieService.deleteAllDirectors();
        return new ResponseEntity<>(d, HttpStatus.OK);
    }
}
