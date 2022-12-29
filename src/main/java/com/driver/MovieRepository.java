package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.management.modelmbean.ModelMBeanConstructorInfo;
import java.security.DigestException;
import java.util.*;

//Pair class
//class Pair{
//    String movie;
//    String director;
//    public Pair(String movie, String director){
//        this.movie = movie;
//        this.director = director;
//    }
//}
@Component
@Repository
public class MovieRepository {
    private Map<String, Movie> movieDb = new HashMap<>(); //database for movie
    private Map<String, Director> directorDb = new HashMap<>(); //database for director
    private Map<String, List<String>> pairDb = new HashMap<>(); //database for pair

//    static{
//        movieDb.put(null, (new Movie("Mission Impossible", 124,9.9)));
//    }

    //add movie to db
    public void saveMovie(Movie movie){
        movieDb.put(movie.getName(),movie);
    }

    //add director to db
    public void saveDirector(Director director){
        directorDb.put(director.getName(), director);
    }

    //save movie director pair
    public void saveMovieDirectorPair(String movie, String Director){

        if(directorDb.containsKey(Director) && movieDb.containsKey(movie)){
            List<String> currentMovies=new ArrayList<>();
            if(pairDb.containsKey(Director)){
                currentMovies=pairDb.get(Director);
                currentMovies.add(movie);
                pairDb.put(Director,currentMovies);
            }
        }
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

        List<String> movies = new ArrayList<String>();
        if(pairDb.containsKey(director)){
            //1. Find the movie names by director from the pair
            movies = pairDb.get(director);

            //2. Deleting all the movies from movieDb by using movieName
            for(String movie: movies){
                if(movieDb.containsKey(movie)){
                    movieDb.remove(movie);
                }
            }

            //3. Deleteing the pair
            pairDb.remove(director);
        }

        //4. Delete the director from directorDb.
        if(directorDb.containsKey(director)){
            directorDb.remove(director);
        }
    }



    //Delete all directors and all movies by them from the records
    public void deleteAllDirectorFromDb(){

        HashSet<String> moviesSet = new HashSet<String>();

        //Deleting the director's map
        directorDb = new HashMap<>();

        //Finding out all the movies by all the directors combined
        for(String director: pairDb.keySet()){

            //Iterating in the list of movies by a director.
            for(String movie: pairDb.get(director)){
                moviesSet.add(movie);
            }
        }

        //Deleting the movie from the movieDb.
        for(String movie: moviesSet){
            if(movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
        //clearing the pair.
        pairDb = new HashMap<>();
    }
}
