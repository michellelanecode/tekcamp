package com.teksystems.bootcamp.springboot.movierental.controllers;

import com.teksystems.bootcamp.springboot.movierental.entities.Customer;
import com.teksystems.bootcamp.springboot.movierental.entities.Film;
import com.teksystems.bootcamp.springboot.movierental.entities.Rating;
import com.teksystems.bootcamp.springboot.movierental.entities.Review;
import com.teksystems.bootcamp.springboot.movierental.errorhandling.NotFoundException;
import com.teksystems.bootcamp.springboot.movierental.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class ReviewController {


    @Autowired
    private ReviewRepository reviewRepository;

    //get / reviews
    // retrieve all reviews
    @GetMapping("/api/reviews")
    public List<Review> retrieveAllReviews(){
        return reviewRepository.findAll();
    }

    // get / review/{id}
    // retrieve review by id
    @GetMapping("/api/reviews/{id}")
    public Optional<Review> retrieveReview(@PathVariable Integer id){
        Optional<Review> foundReview = reviewRepository.findById(id);
        if(foundReview.isEmpty()){
            throw new NotFoundException("id-" + id + " Not Found!");
        }
        return foundReview;
    }

    @GetMapping("/api/reviews/{id}/film")
    public Film retrieveStarReview(@PathVariable Integer id){
        Optional<Review> foundReview = reviewRepository.findById(id);
        return foundReview.get().getFilm();
    }

    @GetMapping("/api/reviews/{id}/customer")
    public Customer retrieveUserReviewDescription(@PathVariable Integer id){
        Optional<Review> foundReview = reviewRepository.findById(id);
        if(!foundReview.isPresent()){
            throw new NotFoundException("id-" + id + " User Description Is Not Found!");
        }
        return foundReview.get().getCustomer();
    }

    //input - details of user
    //output created and return the created URI
    @PostMapping("/api/reviews")
    public void createReview(@Valid @RequestBody Review review){
        Review newReview = reviewRepository.save(review);
    }

    @PutMapping("/api/reviews/{id}")
    public void updateSingleReview(@PathVariable Integer id, @RequestBody Short filmId, Short customerId, Short ratingId, String review){
        Optional<Review> foundReview = reviewRepository.findById(id);
        if(!foundReview.isPresent()){
            throw new NotFoundException("id-" + id + " Not Found!");
        }
            foundReview.get().setReview(review);
            foundReview.get().getRating().setRating_id(ratingId);
            foundReview.get().getCustomer().setCustomerId(customerId);
            foundReview.get().getFilm().setFilm_id(filmId);
    }

    @DeleteMapping("/api/reviews/{id}")
    public void deleteReview(@PathVariable Integer id){
        Optional<Review> foundReview = reviewRepository.findById(id);
        if(foundReview.isEmpty()){
            throw new NotFoundException("id-" + id + " Not Found!");
        }
        reviewRepository.deleteById(id);
    }

}
