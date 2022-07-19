package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="film")
public class Film {

    @Getter
    @javax.persistence.Id
    private int Id;

    @Getter
    private String title;

    String description;

    int releaseYear;

    int languageId;

    String originalLanguage;

    int rentalDuration;

    double rentalRate;

    int length;

    double replacementCost;

    String rating;
    String specialFeatures;
    Date lastUpdate;

    @OneToMany(mappedBy = "film")
    List<Review> reviews;


}
