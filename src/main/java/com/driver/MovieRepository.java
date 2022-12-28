package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MovieRepository {
    Map<String, Movie> movieDb = new HashMap<>();

    //add movie to db
    String addMovieToDb(Movie movie){
        String mName = movie.getName();
        movieDb.put(mName, movie);
        return "Successfully added";
    }


    //add director to db

    //Pair an existing movie and director

    //Get Movie by movie name

    //Get Director by director name

    //Get List of movies name for a given director name

    //Get List of all movies added

    //Delete a director and its movies from the records

    //Delete all directors and all movies by them from the records
}
