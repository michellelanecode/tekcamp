package com.teksystems.bootcamp.capstone2.characters;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
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
       sequentialTransition.setCycleCount(1);
        sequentialTransition.play();
        int health = getHealthTypeLevel();
        setHealthTypeLevel(health - 10);
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("All actions have consequences! You've lost 10 health because you swam across a huge lake draining your energy!");
        message.show();
    }
    public void jumpOver(ImageView image){

        TranslateTransition walk = new TranslateTransition(Duration.millis(2000), image);
        walk.setByX(-250);
        walk.setCycleCount(1);

        TranslateTransition jump = new TranslateTransition(Duration.millis(2000), image);
        jump.setByY(-150);
        jump.setByX(-200);
        jump.setCycleCount(1);

        FadeTransition blink = new FadeTransition(Duration.millis(500), image);
        blink.setFromValue(0.2);
        blink.setToValue(1.0);
        blink.setCycleCount(3);

        RotateTransition rotate = new RotateTransition(Duration.millis(100), image);
        rotate.setToAngle(-180);
        rotate.setCycleCount(1);

        TranslateTransition drop = new TranslateTransition(Duration.millis(2000), image);
        drop.setByY(500);
        drop.setCycleCount(1);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                walk, jump, blink, rotate, drop
        );
        sequentialTransition.setCycleCount(1);
        sequentialTransition.play();

        int health = getHealthTypeLevel();
        setHealthTypeLevel(health - 30);
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("All actions have consequences! You've lost 30 health getting hurt trying to jump over a lake. SILLY!");
        message.show();
    }
}
