package com.example.Moviestore;

import com.example.Moviestore.Buyer.Buyer;
import com.example.Moviestore.Buyer.BuyerRepository;
import com.example.Moviestore.Director.Director;
import com.example.Moviestore.Director.DirectorRepository;
import com.example.Moviestore.Movie.Movie;
import com.example.Moviestore.Movie.MovieRepository;
import com.example.Moviestore.Orders.Order;
import com.example.Moviestore.Orders.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieStoreService {
    private final BuyerRepository buyerRepository;
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public MovieStoreService(@Qualifier("buyer")BuyerRepository buyerRepository, @Qualifier("director")DirectorRepository directorRepository,
                             @Qualifier("movie")MovieRepository movieRepository, @Qualifier("order")OrderRepository orderRepository) {
        this.buyerRepository = buyerRepository;
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
        this.orderRepository = orderRepository;
    }

    //Buyerservice

    public Iterable<Buyer> getAllBuyer(){
        return this.buyerRepository.findAll();
    }

    public Optional<Buyer> getBuyerById(Long id) {
        return this.buyerRepository.findById(id);
    }

    public Optional<Buyer> getBuyerByName(String name) {
        return this.buyerRepository.findByName(name);
    }

    public Iterable<Buyer> getByCountry(String country) {
        return this.buyerRepository.findByCountry(country);
    }

    public Optional<Buyer> getBuyerByEmail(String email) {
        return this.buyerRepository.findByEmail(email);
    }


    public void addNewBuyer(Buyer buyer){
        Optional<Buyer> buyerOptional = this.buyerRepository.findByEmail(buyer.getEmail());
        if(buyerOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"email already taken!");
        }
        else{
            this.buyerRepository.save(buyer);
        }
    }


    public void updateBuyer(Buyer buyer,Long id) {
        Optional<Buyer> buyerOptional = this.buyerRepository.findById(id);
        if(!buyerOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Buyer id not found!");
        }
        else{
            Buyer buyerToUpdate = buyerOptional.get();
            buyerToUpdate = buyer;
            this.buyerRepository.save(buyerToUpdate);

        }
    }

    public void deleteBuyer(Long id) {
        Optional<Buyer> buyerOptional = this.buyerRepository.findById(id);
        if(!buyerOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Buyer id not found!");
        }
        else{
            Buyer buyerToDelete = buyerOptional.get();
            this.buyerRepository.delete(buyerToDelete);
        }
    }

    //Directorservice
    public List<Director> getAll() {
        return this.directorRepository.findAll();
    }

    public Optional<Director> findById(Long id) {
        return this.directorRepository.findById(id);
    }

    public void addNewDirector(Director director) {
        Optional<Director> directorOptional = this.directorRepository.findByName(director.getName());
        if(directorOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Director with given name already exists");
        }
        else{
            this.directorRepository.save(director);
        }
    }

    public void updateDirector(Director director, Long id) {
        Optional<Director> directorOptional = this.directorRepository.findById(id);
        if(!directorOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Director with given id not found");
        }
        else{
            Director directorToUpdate = directorOptional.get();
            directorToUpdate = director;
            this.directorRepository.save(directorToUpdate);
        }
    }

    public void deleteDirectorById(Long id) {
        Optional<Director> directorOptional = this.directorRepository.findById(id);
        if(!directorOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Director with given id not found");
        }
        else{
            Director directorToDelete = directorOptional.get();
            this.directorRepository.delete(directorToDelete);
        }
    }

    //Movieservice
    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return this.movieRepository.findById(id);
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = this.movieRepository.findByName(movie.getName());
        if(movieOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Movie with given name already exists");
        }
        else{
            this.movieRepository.save(movie);
        }
    }

    public void updateMovieById(Movie movie , Long id) {
        Optional<Movie> movieOptional = this.movieRepository.findById(id);
        if(!movieOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie with given id not found");
        }
        else{
            Movie movieToUpdate = movieOptional.get();
            movieToUpdate =movie;
            this.movieRepository.save(movieToUpdate);
        }
    }

    public void deleteMovieById(Long id) {
        Optional<Movie> movieOptional = this.movieRepository.findById(id);
        if(!movieOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie with given id not found");
        }
        else{
            Movie movieToDelete = movieOptional.get();
            this.movieRepository.delete(movieToDelete);
        }
    }

    /*
    public List<Movie> getMovieByDirectorName(String name) {
        Optional<Director> directorOptional= this.directorRepository.findByName(name);
        if(!directorOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Director with given name not found");
        }
        Director director = directorOptional.get();
        return  this.movieRepository.findbyDirector_id(director.getId());
    */

    //Orderservice
    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return this.orderRepository.findById(id);
    }
/*
    public List<Order> getOrderByBuyerName(String name) {
        Optional<Buyer> buyerOptional = this.buyerRepository.findByName(name);
        if(buyerOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Buyer with given name not found");
        }
        Buyer buyer = buyerOptional.get();
        return this.orderRepository.findByBuyerName(buyer.getName());
    }


    public List<Order> getOrderByMovieName(String name) {
        Optional<Movie> movieOptional = this.movieRepository.findByName(name);
        if(!movieOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Movie with given name not found");
        }
        Movie movie = movieOptional.get();
        return this.orderRepository.findByMovie_id(movie.getId());
    }

     */
    //get open orders
    public List<Order> getOrderOpen(){
        return this.orderRepository.findByOpenorder(true);
    }

    public List<Order> getDoneOrder() {
        return this.orderRepository.findByOpenorder(false);
    }

    //NEED TO FIX LOCALDATE TO SQL DATE BUG
    public List<Order> getOrderOpenLongerThan3Months() {
        LocalDate currentDateMinus3Months = LocalDate.now().minusMonths(3);
        return this.orderRepository.findByOpenorderAndOrderdateLessThan(true,currentDateMinus3Months);
    }

    public void addNewOrder(Order order) {
        this.orderRepository.save(order);
    }

    public void updateOrder(Order order, Long id) {
        Optional<Order> orderOptional = this.orderRepository.findById(id);
        if(!orderOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order with given id not found");
        }
        else{
            Order orderToUpdate = orderOptional.get();
            orderToUpdate = order;
            this.orderRepository.save(orderToUpdate);
        }
    }

    public void deleteOrderById(Long id) {
        Optional<Order> orderOptional = this.orderRepository.findById(id);
        if(!orderOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order with given id not found");
        }
        else{
            Order orderToDelete = orderOptional.get();
            this.orderRepository.delete(orderToDelete);
        }
    }



}
