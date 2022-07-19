package com.teksystems.bootcamp.springboot.movierental.entities;

public class Rating {

    private Integer id;
    private Integer starRating;
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
