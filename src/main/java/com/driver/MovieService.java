package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    String addMovie(Movie movie){
        String result = movieRepository.addMovieToDb(movie);
        return result;
    }

    String addDirector(Director director){
        String result = movieRepository.addDirectorToDb(director);
        return result;
    }

    Pair addMovieDirectorPair() {
        Pair result = movieRepository.addMovieDirectorPair();
        return result;
    }
    String getMovieByMovieName(Movie movie){
        Movie movieName = movieRepository.getMovieByMovieName(movie);
        return movieName;
    }
}
