package com.teksystems.bootcamp.springboot.movierental.entities;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="film")
public class Film {

    @Getter
    @javax.persistence.Id
    private int id;
    @Getter
    private String title;

}
