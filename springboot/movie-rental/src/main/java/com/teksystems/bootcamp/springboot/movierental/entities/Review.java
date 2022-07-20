package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="review")
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer reviewId;

    public Integer getReviewId() {
        return reviewId;
    }

    //foreign key of rating id
    @OneToOne
    @JoinColumn(name="rating_id")
    private Rating rating;
    public Integer getRatingId(){
        return rating.getId();
    }

    //foreign key of user id from customer
    @OneToOne
    @JoinColumn(name="customer_id")
    Customer customer;
    public Integer getCustomerId(){
        return customer.getId();
    }

    public String getCustomerFirstName(){
        return getCustomerFirstName();
    }

    public String getCustomerLastName(){
        return getCustomerLastName();
    }

    //foreign key of film_id from film
    @OneToOne
    @JoinColumn(name="film_id")
    private Film film;
    public Integer getFilmId(){
        return film.getId();
    }

    public String getFilmTitle(){
        return film.getTitle();
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setFilm(Film film) {
        this.film = film;
    }


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
