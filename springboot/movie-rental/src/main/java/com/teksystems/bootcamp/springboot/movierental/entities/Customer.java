package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Getter
    int id;
    @Getter
    int storeId;
    @Getter
    String firstName;
    @Getter
    String lastName;
    @Getter
    String email;
    @Getter
    int addressId;
    @Getter
    int active;
    @Getter
    Date createDate;
    @Getter
    Date lastUpdate;

    @OneToMany(mappedBy = "customer")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;

    @ManyToOne
    private Rating rating;


}
