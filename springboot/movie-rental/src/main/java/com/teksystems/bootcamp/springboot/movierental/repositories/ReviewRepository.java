package com.teksystems.bootcamp.springboot.movierental.repositories;

import com.teksystems.bootcamp.springboot.movierental.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
