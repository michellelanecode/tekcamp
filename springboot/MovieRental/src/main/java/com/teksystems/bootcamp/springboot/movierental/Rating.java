package com.teksystems.bootcamp.springboot.movierental;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity

@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rating_id")
    @Getter @Setter
    private Integer id;


    @Column(name="rating_description")
    @Getter @Setter
    private String ratingDescription;


    @Column
    @Getter @Setter
    @Range(max=5, message="Rating value must be between 0-5")
    private Integer starRating;



}
