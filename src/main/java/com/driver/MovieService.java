package com.driver;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
       movieRepository.saveMovie(movie);

    }

    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director) {
        movieRepository.saveMovieDirectorPair(movie, director);
    }
    public Movie getMovieByName(String searchM){
        return movieRepository.getMovie(searchM);
    }
    public Director getDirectorByName(String d){
       return movieRepository.getDirector(d);
    }
    public List<String> getMoviesByDirectorName(String dName){
        return movieRepository.getMoviesByDirectorNameFromDb(dName);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMoviesFromDb();

    }
    public void deleteDirectorByName(String searchDirector){
        movieRepository.deleteDirectorFromDb(searchDirector);

    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectorFromDb();
    }
}
