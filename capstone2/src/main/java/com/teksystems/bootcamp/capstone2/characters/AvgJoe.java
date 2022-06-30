package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.player.PlayerInformation;
import com.teksystems.bootcamp.capstone2.controllers.ToBeHumaansController;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AvgJoe extends Character {


    public void sleepIn(PlayerInformation playerInformation, Rectangle characterHealth){
        ToBeHumaansController.controls.getNowPlaying().stop();
        playerInformation.updatePlayerHealth(characterHealth, 25);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You're gonna be late lose 25 health points!");
        message.show();
    }

    public void wakeUpEarly(PlayerInformation playerInformation, Rectangle characterHealth){
        ToBeHumaansController.controls.getNowPlaying().stop();
        playerInformation.updatePlayerHealth(characterHealth, 10);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You didn't get enough rest lose 10 health points!");
        message.show();
    }

    public void waitForBus(ImageView bus, Rectangle joeHealth){
        PlayerInformation playerInformation = getPlayer();
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
        ToBeHumaansController.controls.changeSong(ToBeHumaansController.sceneMusic.getMissedBus());
        playerInformation.updatePlayerHealth(joeHealth, 20);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
        Alert warning = new Alert(Alert.AlertType.NONE, "The missed the bus and have to walk!  Lose 20 health points!", ButtonType.CLOSE );
        warning.show();
    }

    public void walkToWork(ImageView image, Rectangle joeHealth){
        PlayerInformation playerInformation = getPlayer();
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
        ToBeHumaansController.controls.changeSong(ToBeHumaansController.sceneMusic.getJumpSound());
        playerInformation.updatePlayerHealth(joeHealth, 10);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
        Alert warning = new Alert(Alert.AlertType.NONE, "Already tired and you choose to walk?!  Lose 10 health points!", ButtonType.CLOSE );
        warning.show();
    }
}
