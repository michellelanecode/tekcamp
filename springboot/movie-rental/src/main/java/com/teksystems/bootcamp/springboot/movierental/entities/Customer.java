package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Getter
    int id;
    @Getter
    String firstName;
    @Getter
    String lastName;


    @OneToMany(mappedBy = "customer")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;

    @ManyToOne
    private Rating rating;


}
