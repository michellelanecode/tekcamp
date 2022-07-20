package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Getter
    @Setter
    @Column(name="customer_id")
    Short customerId;
    @Getter
    @Column(name="store_id")
    Short storeId;

    @Getter
    @Column(name="first_name")
    String firstName;

    @Getter
    @Column(name="last_name")
    String lastName;



}
