package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.management.modelmbean.ModelMBeanConstructorInfo;
import java.security.DigestException;
import java.util.*;


@Repository
public class MovieRepository {
    Map<String, Movie> movieDb = new HashMap<>(); //database for movie
    Map<String, Director> directorDb = new HashMap<>(); //database for director
    Map<String, List<String>> pairDb = new HashMap<>(); //database for pair

    //add movie to db
    public void saveMovie(Movie movie){
        movieDb.put(movie.getName(),movie);
    }

    //add director to db
    public void saveDirector(Director director){
        directorDb.put(director.getName(), director);
    }

    //save movie director pair
    public void saveMovieDirectorPair(String movie, String director){

        List<String> movieList = pairDb.getOrDefault(director,new ArrayList<>());
        movieList.add(movie);
        pairDb.put(director,movieList);
    }

    //get movie by name
    public Movie getMovie(String movie){
       return movieDb.get(movie);
    }

    //get director by name
    public Director getDirector(String director){
        return directorDb.get(director);
    }

    //Get List of movies name for a given director name
    public List<String> getMoviesByDirectorNameFromDb(String directorName){
        List<String> moviesList = new ArrayList<String>();
        if(pairDb.containsKey(directorName)) moviesList = pairDb.get(directorName);
        return moviesList;
    }

    //Get List of all movies added
    public List<String> findAllMoviesFromDb(){
        return new ArrayList<>(movieDb.keySet());
    }

    //Delete a director and its movies from the records
    public void deleteDirectorFromDb(String director){
        List<String> studentList = pairDb.get(director);
        for(String student : studentList){
            if(movieDb.containsKey(student)){
                movieDb.remove(student);
            }
        }
        pairDb.remove(director);
        }

    //Delete all directors and all movies by them from the records
    public void deleteAllDirectorFromDb(){
        for(String teacher : pairDb.keySet()){
            List<String> studentList = pairDb.get(teacher);
            for(String student : studentList){
                if(movieDb.containsKey(student)){
                    movieDb.remove(student);
                }
            }
        }
        pairDb.clear();
    }
}
