package com.teksystems.bootcamp.springboot.movierental.entities;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

public class Rating {

    private Integer id;

    @Range(max=5, message="Rating should be between 0-5")
    private Integer starRating;

    @Size(min=2, message="Description should be at least 2 characters long")
    private String userRatingDescription;

    public Rating(Integer id, Integer starRating, String userRatingDescription) {
        this.id = id;
        this.starRating = starRating;
        this.userRatingDescription = userRatingDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public String getUserRatingDescription() {
        return userRatingDescription;
    }

    public void setUserRatingDescription(String userRatingDescription) {
        this.userRatingDescription = userRatingDescription;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", starRating=" + starRating +
                ", userRatingDescription='" + userRatingDescription + '\'' +
                '}';
    }
}
