package com.example.Moviestore.Controller;

import com.example.Moviestore.Entity.Order;
import com.example.Moviestore.MovieStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/oders")
public class OrderController {
    private final MovieStoreService movieStoreService;

    @Autowired
    public  OrderController(MovieStoreService movieStoreService){
        this.movieStoreService = movieStoreService;
    }

    @GetMapping
    public Iterable<Order> getAllOrders(){
        return  this.movieStoreService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable(name = "id") Long id){
        return this.movieStoreService.getOrderById(id);
    }

    @GetMapping("/openOrders")
    public List<Order> getOpenOrders(){
        return  this.movieStoreService.getOrderOpen();
    }

    @GetMapping("/doneOrders")
    public  List<Order> getDoneOrders(){
        return this.movieStoreService.getDoneOrder();
    }

    @GetMapping("/ordersLongerThan3Months")
    public List<Order> getOrdersOpenLongerThan3Months(){
        return this.movieStoreService.getOrderOpenLongerThan3Months();
    }

    @PostMapping
    public void addNewOrder(@RequestBody Order order){
        this.movieStoreService.addNewOrder(order);
    }

    @PutMapping("/update/{id}")
    public void updateOrder(@PathVariable(name = "id") Long id, @RequestBody Order order){
        this.movieStoreService.updateOrder(order,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable(name = "id") Long id){
        this.movieStoreService.deleteOrderById(id);
    }
}
