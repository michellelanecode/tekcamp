package com.teksystems.bootcamp.springboot.movierental.services;


import com.teksystems.bootcamp.springboot.movierental.entities.Rating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RatingDAOService {
    private static Integer ratingCount = 4;
    private static List<Rating> ratings = new ArrayList<>();

    static {
        ratings.add(new Rating(1, 5, "best movie ever"));
        ratings.add(new Rating(2, 4, "pretty good movie"));
        ratings.add(new Rating(3, 3, "it was okay"));
        ratings.add(new Rating(4, 1, "wouldn't watch again"));
    }

    public List<Rating> getAllRatingsFromDatabase() {
        return ratings;
    };

    public Rating addRatingToDatabase(Rating newRating){
        if (newRating.getId() == null){
            newRating.setId(++ratingCount);
        }
        ratings.add(newRating);
        return newRating;
    }

    public Rating getRatingByIdFromDatabase(Integer id){
        for(Rating rating: ratings){
            if (rating.getId() == id){
                return rating;
            }
        }
        return null;
    }



}
