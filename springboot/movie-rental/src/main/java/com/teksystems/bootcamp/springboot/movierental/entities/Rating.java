package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "rating", schema = "sakila")
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy="rating")
    private List<Customer> customers;


    @OneToMany(mappedBy = "rating")
    private List<Review> reviews;
    @Range(max=5, message="Rating should be between 0-5")
    @Column(name="star_rating", nullable = false)
    private Integer starRating;

    @Size(min=2, message="Description should be at least 2 characters long")
    @Column(name="rating_description", nullable = false)
    private String ratingDescription;

    public Rating(Integer id, Integer starRating, String userRatingDescription) {
        this.id = id;
        this.starRating = starRating;
        this.ratingDescription = userRatingDescription;
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

    public String getRatingDescription() {
        return ratingDescription;
    }

    public void setRatingDescription(String userRatingDescription) {
        this.ratingDescription = userRatingDescription;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", starRating=" + starRating +
                ", ratingDescription='" + ratingDescription + '\'' +
                '}';
    }
}
