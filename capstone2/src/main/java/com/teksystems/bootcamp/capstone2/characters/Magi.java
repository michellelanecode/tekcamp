package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.controllers.ToBeHumaansController;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Magi extends Character {

    public void eatMushroom(ImageView image, ImageView mushroom, Rectangle characterHealth){
        ToBeHumaansController.controls.changeSong(ToBeHumaansController.sceneMusic.getAteMushroom());
        TranslateTransition walk = new TranslateTransition(Duration.millis(2000), image);
        walk.setByX(350);
        walk.setCycleCount(1);

        FadeTransition blink = new FadeTransition(Duration.millis(1000), mushroom);
        blink.setFromValue(1.0);
        blink.setToValue(0);
        blink.setCycleCount(4);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                walk, blink
        );
        sequentialTransition.setCycleCount(1);
        sequentialTransition.play();

        getPlayer().updatePlayerHealth(characterHealth, 20);
        getPlayer().setPlayerHealthBar(getPlayer().getPlayerHealthBar());
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You've lost 20 magic points because you ate a strange mushroom!");
        message.show();

    }
    public void swim(ImageView image, Rectangle characterHealth){
        ToBeHumaansController.controls.changeSong(ToBeHumaansController.sceneMusic.getSwimSound());
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
        getPlayer().updatePlayerHealth(characterHealth, 10);
        getPlayer().setPlayerHealthBar(getPlayer().getPlayerHealthBar());
        Alert warning = new Alert(Alert.AlertType.NONE, "You swam across a huge lake?! That takes energy! Lose 10 health points!", ButtonType.CLOSE );
        warning.setX(566);
        warning.setY(285);
        warning.show();

    }
    public void jumpOver(ImageView image, Rectangle characterHealth){
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
        ToBeHumaansController.controls.changeSong(ToBeHumaansController.sceneMusic.getJumpSound());
        getPlayer().updatePlayerHealth(characterHealth, 30);
        getPlayer().setPlayerHealthBar(getPlayer().getPlayerHealthBar());
        Alert warning = new Alert(Alert.AlertType.NONE, "You tried to jump over the lake?! Lose 30 health points!", ButtonType.CLOSE );
        warning.setX(566);
        warning.setY(285);
        warning.show();
    }
}
