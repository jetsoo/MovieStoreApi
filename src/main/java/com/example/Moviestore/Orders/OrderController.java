package com.example.Moviestore.Orders;

import com.example.Moviestore.Buyer.Buyer;
import com.example.Moviestore.MovieStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    private final MovieStoreService movieStoreService;

    @Autowired
    public OrderController(MovieStoreService movieStoreService) {
        this.movieStoreService = movieStoreService;
    }


    //BASEPATH
    @GetMapping
    public List<Order> getAll(){
        return this.movieStoreService.getAllOrders();
    }

    @GetMapping(value = "/{id}")
    public Optional<Order> getById(@PathVariable Long id){
        return this.movieStoreService.getOrderById(id);
    }
/*
    //get orders by buyerName
    @GetMapping(value = "/byBuyerName/{name}")
    public List<Order> getOrderByBuyerName(@PathVariable(name = "country") String name){
        return this.movieStoreService.getOrderByBuyerName(name);
    }
    //get orders by moviename
    @GetMapping(value = "/byMovieName/{name}")
    public List<Order> getOrderByMovieName(@PathVariable String name){
        return this.movieStoreService.getOrderByMovieName(name);
    }

 */
    //get orders by orderDate > 3 months AND openorder true
    @GetMapping(value = "/orderLongerThan3Months")
    public List<Order> getOrdersOpenLongerThan3Months(){
        return this.movieStoreService.getOrderOpenLongerThan3Months();
        }

    @GetMapping(value = "/openorder")
    public List<Order> getOpenOrders(){
        return this.movieStoreService.getOrderOpen();
    }

    @GetMapping(value = "/doneorder")
    public List<Order> getDoneOrders(){
        return this.movieStoreService.getDoneOrder();
    }


    @PostMapping
    public void addOrder(@RequestBody Order order){
        this.movieStoreService.addNewOrder(order);
    }

    @PostMapping(value = "/update/{id}")
    public void updateOrder(@RequestBody Order order, @PathVariable Long id){
        this.movieStoreService.updateOrder(order,id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        this.movieStoreService.deleteOrderById(id);
    }
}
