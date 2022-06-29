package com.teksystems.bootcamp.capstone2.characters;

import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Magi extends Character {

    public Magi(String healthType, ImageView characterSprite) {
        super(healthType, characterSprite);
    }

    public void eatMushroom(){
       int health = getHealthTypeLevel();
      setHealthTypeLevel(health - 30);
    }
    public void swim(ImageView image){

        TranslateTransition walk = new TranslateTransition(Duration.millis(2000), image);
        walk.setByX(-250);
        walk.setCycleCount(1);

        RotateTransition dive = new RotateTransition(Duration.millis(100), image);
        dive.setToAngle(-180);
        dive.setCycleCount(1);

        TranslateTransition swim = new TranslateTransition(Duration.millis(2000), image);
        swim.setByY(120);
        swim.setCycleCount(1);

        RotateTransition rotate = new RotateTransition(Duration.millis(100), image);
        rotate.setToAngle(-90);
        rotate.setCycleCount(1);

        TranslateTransition swim2 = new TranslateTransition(Duration.millis(2000), image);
        swim2.setByX(-500);
        swim2.setCycleCount(1);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                walk, dive, swim, rotate, swim2
        );
       sequentialTransition.setCycleCount(Timeline.INDEFINITE);
        sequentialTransition.play();

        int health = getHealthTypeLevel();
        setHealthTypeLevel(health - 20);
    }
    public void walkAround(){
        int health = getHealthTypeLevel();
        setHealthTypeLevel(health - 10);
    }
}
