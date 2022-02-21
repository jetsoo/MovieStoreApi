package com.example.Moviestore.Movie;

import com.example.Moviestore.MovieStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movie")
public class MovieController {
    private final MovieStoreService movieStoreService;

    @Autowired
    public MovieController(MovieStoreService movieStoreService) {
        this.movieStoreService = movieStoreService;
    }


    @GetMapping
    public List<Movie> getAll(){
        return this.movieStoreService.getAllMovies();
    }

    @GetMapping(value = "/{id}")
    public Optional<Movie> getById(@PathVariable(name ="id") Long id){
        return this.movieStoreService.getMovieById(id);
    }

    //get movies by author name
    /*
    @GetMapping(value = "/byDirector/{directorName}")
    public List<Movie> getMovieByDirector(@PathVariable(name = "directorName") String name){
        return this.movieStoreService.getMovieByDirectorName(name);
    }
    */

    @PostMapping
    public void addMovie(@RequestBody Movie movie){
        this.movieStoreService.addNewMovie(movie);
    }

    @PutMapping(value = "/update/{id}")
    public void updateMovie(@RequestBody Movie movie ,@PathVariable(name = "id") Long id){
        this.movieStoreService.updateMovieById(movie , id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteMovie(@PathVariable Long id){
        this.movieStoreService.deleteMovieById(id);
    }
}
