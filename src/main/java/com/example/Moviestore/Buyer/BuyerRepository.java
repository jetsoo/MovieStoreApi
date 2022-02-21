package com.example.Moviestore.Buyer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Qualifier("buyer")
@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Long> {

    Optional<Buyer> findByName(String name);
    Iterable<Buyer> findByCountry(String country);
    Optional<Buyer> findByEmail(String email);
}
