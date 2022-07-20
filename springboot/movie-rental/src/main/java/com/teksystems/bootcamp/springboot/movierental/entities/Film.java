package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="film")
public class Film {

    @Getter
    @javax.persistence.Id
    private int Id;

    @OneToMany(mappedBy = "film")
    List<Review> reviews;


}
