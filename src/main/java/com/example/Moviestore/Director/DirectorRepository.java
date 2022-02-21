package com.example.Moviestore.Director;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Qualifier("director")
@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {

    Optional<Director> findByName(String name);

}
