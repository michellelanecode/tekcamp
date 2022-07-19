package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer reviewId;

    //foreign key of rating id
    @Getter @Setter
@ManyToOne
private Rating rating;
    //foreign key of user id from customer
@ManyToOne
@Getter @Setter
private Customer customer;
    //foreign key of film_id from film

@ManyToOne
@Getter @Setter
    private Film film;
    //foreign key of title from film


    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", customer=" + customer +
                ", film=" + film +
                '}';
    }
}
