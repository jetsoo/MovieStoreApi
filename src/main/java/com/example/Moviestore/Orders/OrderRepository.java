package com.example.Moviestore.Orders;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.From;
import java.time.LocalDate;
import java.util.List;

import static org.postgresql.core.SqlCommandType.SELECT;

@Qualifier("order")
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {




    List<Order> findByOpenorder(boolean b);

    List<Order> findByOpenorderAndOrderdateLessThan(boolean b, LocalDate currentDateMinus3Months);

   // @Query("SELECT id,openorder FROM orders WHERE buyer_id = (SELECT id FROM buyer WHERE name = inputName)")
    //List<Order> findByBuyerName(String inputName);
}
