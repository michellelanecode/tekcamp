package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="film")
public class Film {

    @Id
    //add column annotation to each column use name in sql
    @Getter @Setter
    @Column(name = "film_id")
    private Short film_id;
    @Getter @Setter
    @Column(name = "title")
    private String title;


}
