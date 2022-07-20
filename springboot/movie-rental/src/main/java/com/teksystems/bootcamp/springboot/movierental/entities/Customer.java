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

    @Getter
    @Column(name="email")
    String email;

    @Getter
    @Column(name="address_id")
    Short addressId;

    @Getter
    @Column(name="active")
    Boolean active;

    @Getter
    @Column(name="create_date")
    Date createDate;

    @Getter
    @Column(name="last_update")
    Date lastUpdate;

    @Getter
    @Column(name="id")
    Integer id;

}
