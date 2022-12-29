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

    Pair addMovieDirectorPair(Pair pair) {
        Pair result = movieRepository.addMovieDirectorPairFromDb();
        return result;
    }
    Movie getMovieByMovieName(String searchM){
        Movie result = movieRepository.getMovieByMovieNameFromDb(searchM);
        return result;
    }
    Director getDirectorByDirectorName(String d){
        Director result = movieRepository.getDirectorByDirectorNameFromDb(d);
        return result;
    }
    Movie getMovieByDirectorName(String dName){
        Movie result = movieRepository.getMovieByDirectorNameFromDb(dName);
        return result;
    }
    Movie findAllMovies(){
        Movie result = movieRepository.findAllMoviesFromDb();
        return result;
    }
    Pair deleteDirectorByName(String searchDirector){
        Pair pair = movieRepository.deleteDirectorByNameFromDb(searchDirector);
        return pair;
    }
    Director deleteAllDirectors(){
        return movieRepository.deleteAllDirectorFromDb();
    }
}
