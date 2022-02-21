package com.example.Moviestore.Buyer;

import com.example.Moviestore.MovieStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/buyer")
public class BuyerController {
    private final MovieStoreService movieStoreService;

    @Autowired
    public BuyerController(MovieStoreService movieStoreService) {
        this.movieStoreService = movieStoreService;
    }


    //BASEPATH
    @GetMapping
    public Iterable<Buyer> getAll(){
        return this.movieStoreService.getAllBuyer();
    }

    @GetMapping(value = "/{id}")
    public Optional<Buyer> findById(@PathVariable(name = "id")Long id){
        return this.movieStoreService.getBuyerById(id);
    }

    @GetMapping("/name")
    public Optional<Buyer> findByName(@RequestParam(value = "name") String name){
        return this.movieStoreService.getBuyerByName(name);
    }

    @GetMapping(value = "/country")
    public Iterable<Buyer> findByCountry(@RequestParam(name = "country") String country){
        return this.movieStoreService.getByCountry(country);
    }
    @GetMapping(value = "/email")
    public Optional<Buyer> findByEmail(@RequestParam(name = "email") String email){
        return  this.movieStoreService.getBuyerByEmail(email);
    }

    //CREATE BUYER
    @PostMapping
    public void addBuyer(@RequestBody Buyer buyer){
        this.movieStoreService.addNewBuyer(buyer);
    }

    //UPDATE BUYER BY ID
    @PutMapping(value = "/update/{id}")
    public void updateBuyer(@RequestBody Buyer buyer,@PathVariable Long id){
        this.movieStoreService.updateBuyer(buyer,id);
    }

    //DELETE BUYER BY ID
    @DeleteMapping(value = "/delete/{id}")
    public void deleteBuyer(@PathVariable(name = "id") Long id){
        this.movieStoreService.deleteBuyer(id);
    }


}
