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
    @Getter
    String description;
    @Getter
    int releaseYear;
    @Getter
    int languageId;
    @Getter
    String originalLanguage;
    @Getter
    int rentalDuration;
    @Getter
    double rentalRate;
    @Getter
    int length;
    @Getter
    double replacementCost;
    @Getter
    String rating;
    @Getter
    String specialFeatures;
    @Getter
    Date lastUpdate;

    @OneToMany(mappedBy = "film")
    List<Review> reviews;


}
