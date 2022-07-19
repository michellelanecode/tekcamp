package com.teksystems.bootcamp.springboot.movierental.controllers;

import com.teksystems.bootcamp.springboot.movierental.entities.Rating;
import com.teksystems.bootcamp.springboot.movierental.errorhandling.RatingNotFoundException;
import com.teksystems.bootcamp.springboot.movierental.repositories.RatingRepository;
import com.teksystems.bootcamp.springboot.movierental.services.RatingDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class RatingController {

    @Autowired
    private RatingDAOService ratingService;

    @Autowired
    private RatingRepository ratingRepository;

    //get / ratings
    // retrieve all ratings
    @GetMapping("/api/ratings")
    public List<Rating> retrieveAllRatings(){
        return ratingRepository.findAll();
    }

    // get / rating/{id}
    // retrieve rating by id
    @GetMapping("/api/ratings/{id}")
    public Optional<Rating> retrieveRating(@PathVariable Integer id){
        Optional<Rating> foundRating = ratingRepository.findById(id);
        if(foundRating.isEmpty()){
            throw new RatingNotFoundException("id-" + id + " Not Found!");
        }

        return foundRating;
    }

    @GetMapping("/api/ratings/{id}/starRating")
    public Integer retrieveStarRating(@PathVariable Integer id){
        Optional<Rating> foundRating = ratingRepository.findById(id);
//        if(foundRating.getStarRating()==null){
//            throw new RatingNotFoundException("id-" + id + " Star Rating Not Found!");
//        }
//        return foundRating.getStarRating();
        return null;
    }

    @GetMapping("/api/ratings/{id}/userRatingDescription")
    public String retrieveUserRatingDescription(@PathVariable Integer id){
        Rating foundRating = ratingService.findOne(id);
        if(foundRating.getUserRatingDescription()==null){
            throw new RatingNotFoundException("id-" + id + " User Description Is Not Found!");
        }
        return foundRating.getUserRatingDescription();
    }

    //input - details of user
    //output created and return the created URI
    @PostMapping("/api/ratings")
    public void createRating(@Valid @RequestBody Rating rating){
      Rating newRating = ratingRepository.save(rating);
    }

//    @PostMapping("/api/ratings/{id}")
//    public void updateSingleRating(@PathVariable Integer id, @RequestBody Integer starRating, String userRatingDescription ){
//        Rating foundRating = ratingService.getRatingByIdFromDatabase(id);
//        if(foundRating==null){
//            throw new RatingNotFoundException("id-" + id + " Not Found!");
//        }
//        foundRating.setStarRating(starRating);
//        foundRating.setUserRatingDescription(userRatingDescription);
//    }

    @DeleteMapping("/api/ratings/{id}")
    public void deleteRating(@PathVariable Integer id){
        Rating foundRating = ratingService.findOne(id);
        if(foundRating==null){
            throw new RatingNotFoundException("id-" + id + " Not Found!");
        }
        ratingRepository.deleteById(id);
    }

}
