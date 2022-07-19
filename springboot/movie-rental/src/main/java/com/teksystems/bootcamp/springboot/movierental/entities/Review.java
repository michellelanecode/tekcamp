package com.teksystems.bootcamp.springboot.movierental.entities;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer reviewId;

    //foreign key of rating id
@ManyToOne
private Rating rating;
    //foreign key of user id from customer
@ManyToOne
private Customer customer;
    //foreign key of film_id from film

    @ManyToOne
    private Film film;
    //foreign key of title from film



}
