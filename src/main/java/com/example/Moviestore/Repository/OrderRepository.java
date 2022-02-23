package com.example.Moviestore.Repository;

import com.example.Moviestore.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
   
    List<Order> findByOpenorder(boolean b);

    List<Order> findByOpenorderAndOrderdateLessThan(boolean b, LocalDate currentDateMinus3Months);
}
