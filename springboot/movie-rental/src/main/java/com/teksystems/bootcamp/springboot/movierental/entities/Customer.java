package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
