package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.capstone2.PlayerInformation;
import com.teksystems.bootcamp.capstone2.capstone2.ToBeHumaans;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AvgJoe extends Character {


    public void sleepIn(PlayerInformation playerInformation, Rectangle characterHealth){
        ToBeHumaans.controls.getNowPlaying().stop();
        playerInformation.updatePlayerHealth(characterHealth, 25);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
    }

    public void wakeUpEarly(PlayerInformation playerInformation, Rectangle characterHealth){
        ToBeHumaans.controls.getNowPlaying().stop();
        playerInformation.updatePlayerHealth(characterHealth, 10);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
    }

    public void waitForBus(ImageView bus){
        TranslateTransition driveAway = new TranslateTransition(Duration.millis(1000), bus);
        driveAway.setByX(-300);
        driveAway.setCycleCount(1);

        TranslateTransition driveAway2 = new TranslateTransition(Duration.millis(2000), bus);
        driveAway2.setByX(-1000);
        driveAway2.setCycleCount(1);


        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                driveAway, driveAway2
        );
        sequentialTransition.setCycleCount(1);
        sequentialTransition.play();
    }

    public void walkToWork(ImageView image){
        TranslateTransition walk = new TranslateTransition(Duration.millis(2000), image);
        walk.setByY(130);
        walk.setCycleCount(1);

        RotateTransition turn = new RotateTransition(Duration.millis(100), image);
        turn.setToAngle(-30);
        turn.setCycleCount(1);

        TranslateTransition walkaway = new TranslateTransition(Duration.millis(2000), image);
        walkaway.setByX(300);
        walkaway.setCycleCount(1);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                walk, turn, walkaway
        );
        sequentialTransition.setCycleCount(1);
        sequentialTransition.play();
    }
}
