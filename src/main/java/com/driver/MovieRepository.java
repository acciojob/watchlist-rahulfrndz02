package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.management.modelmbean.ModelMBeanConstructorInfo;
import java.security.DigestException;
import java.util.HashMap;
import java.util.Map;

//Pair class
class Pair{
    String movie;
    String director;
    public Pair(String movie, String director){
        this.movie = movie;
        this.director = director;
    }
}

@Repository
public class MovieRepository {
    static Map<String, Movie> movieDb = new HashMap<>(); //database for movie
    Map<String, Director> directorDb = new HashMap<>(); //database for director
    Map<String, Pair> pairDb = new HashMap<>(); //database for pair

    static{
        movieDb.put(null, (new Movie("Dilwale", 124,7.9)));
    }

    //add movie to db
    String addMovieToDb(Movie movie){
        String mName = movie.getName();
        movieDb.put(mName, movie);
        return "Successfully added";
    }


    //add director to db
    String addDirectorToDb(Director director){
        String dName = director.getName();
        directorDb.put(dName, director);
        return "Successfully added";
    }

    //Pair an existing movie and director
    Pair addMovieDirectorPairFromDb(){
        for(Pair p : pairDb.values()){
            return p;
        }
        return null;
    }

    //Get Movie by movie name
    Movie getMovieByMovieNameFromDb(String movieName){
        for(Movie m : movieDb.values()){
            if(m.equals(movieName)){
                return m;
            }
        }
        return null;
    }

    //Get Director by director name
    Director getDirectorByDirectorNameFromDb(String directorName){
        for(Director d : directorDb.values()){
            if(d.equals(directorName)){
                return d;
            }
        }
        return null;
    }

    //Get List of movies name for a given director name
    Movie getMovieByDirectorNameFromDb(String directorName){
        for(Movie m : movieDb.values()){
            if(m.equals(directorName)){
                return m;
            }
        }
        return null;
    }

    //Get List of all movies added
    Movie findAllMoviesFromDb(){
        for(Movie m : movieDb.values()){
            return m;
        }
        return null;
    }

    //Delete a director and its movies from the records
    Pair deleteDirectorByNameFromDb(String searchDirector){
            return pairDb.remove(searchDirector);
    }

    //Delete all directors and all movies by them from the records
    Director deleteAllDirectorFromDb(){
        for(Director d : directorDb.values()){
            directorDb.remove(d);
        }
        return null;
    }
}
