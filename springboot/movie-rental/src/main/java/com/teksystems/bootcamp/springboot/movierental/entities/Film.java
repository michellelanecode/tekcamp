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
    @Getter @Setter
    @Column(name = "description")
    private String description;
    @Getter @Setter
    @Column(name = "release_year")
    private Short release_year;
    @Getter @Setter
    @Column(name = "language_id")
    private Short language_id; //int
    @Getter @Setter
    @Column(name = "original_language_id")
    private Short original_language_id;
    @Getter @Setter
    @Column(name = "rental_duration")
    private Short rental_duration;
    @Getter @Setter
    @Column(name = "rental_rate")
    private BigDecimal rental_rate;
    @Getter @Setter
    @Column(name = "length")
    private Short length;
    @Getter @Setter
    @Column(name = "replacement_cost")
    private BigDecimal replacement_cost;
    @Getter @Setter
    @Column(name = "rating")
    private String rating;

    @Getter @Setter
    @Column(name = "special_features")
    private String special_features;
    @Getter @Setter
    @Column(name = "last_update")
    private Date last_update;

    @Getter @Setter
    @Column(name="id")
    private Integer id;
}
