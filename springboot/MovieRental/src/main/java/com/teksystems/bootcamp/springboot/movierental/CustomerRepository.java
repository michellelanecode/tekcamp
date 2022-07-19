package com.teksystems.bootcamp.springboot.movierental;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Rating, Integer> {
}
