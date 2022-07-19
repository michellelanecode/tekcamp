package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Getter
    int id;

    int storeId;

    String firstName;

    String lastName;

    String email;

    int addressId;

    int active;

    Date createDate;

    Date lastUpdate;

    @OneToMany(mappedBy = "customer")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "customer")
    private List<Review> reviews;




}
