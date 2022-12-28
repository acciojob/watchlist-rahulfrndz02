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
}
