package com.example.Moviestore.Controller;

import com.example.Moviestore.Entity.Director;
import com.example.Moviestore.MovieStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/director")
public class DirectorController {
    private final MovieStoreService movieStoreService;

    @Autowired
    public DirectorController( MovieStoreService movieStoreService) {
        this.movieStoreService = movieStoreService;
    }

    @GetMapping
    public List<Director> getAll(){
        return this.movieStoreService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Director> findById(@PathVariable(name = "id") Long id){
        return this.movieStoreService.findById(id);
    }

    @PostMapping
    public void addDirector(@RequestBody Director director){
        this.movieStoreService.addNewDirector(director);
    }

    @PutMapping(value = "/update/{id}")
    public void updateDirector(@RequestBody Director director, @PathVariable Long id){
        this.movieStoreService.updateDirector(director,id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteDirector(Long id){
        this.movieStoreService.deleteDirectorById(id);
    }
}
