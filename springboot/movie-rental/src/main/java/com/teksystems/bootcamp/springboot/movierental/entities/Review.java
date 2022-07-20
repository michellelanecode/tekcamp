package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    @Getter
    @Setter
    private Short reviewId;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "rating_id", nullable = false)
    @Getter
    @Setter
    private Rating rating;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @Getter
    @Setter
    @JoinTable(name="reviews", joinColumns = @JoinColumn(name="customer_id"), inverseJoinColumns = @JoinColumn(name="review_id"))
    private Customer customer;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "film_id", columnDefinition = "SMALLINT UNSIGNED NOT NULL", nullable = false)
    @Getter
    @Setter
    private Film film;

    @Column(name = "review")
    @Getter
    @Setter
    private String review;
    //foreign key of rating id


    //foreign key of user id from customer


    //foreign key of film_id from film


    //foreign key of title from film


    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", customer=" + customer +
                ", film=" + film +
                ", review='" + review + '\'' +
                '}';
    }
}
