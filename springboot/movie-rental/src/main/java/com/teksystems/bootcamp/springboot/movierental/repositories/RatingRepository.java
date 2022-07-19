package com.teksystems.bootcamp.springboot.movierental.repositories;


import com.teksystems.bootcamp.springboot.movierental.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
