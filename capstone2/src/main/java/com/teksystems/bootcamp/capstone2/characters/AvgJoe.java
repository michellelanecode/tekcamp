package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.player.PlayerAnimations;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class AvgJoe extends Character {


    public void sleepIn(Rectangle characterHealth){
        new PlayerAnimations().updateHealthBar(characterHealth, 25).play();
        this.setHealthLevel(this.getHealthLevel() - 25);
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("Your actions have consequences! You're gonna be late lose 25 health points!");
        message.show();
    }

    public void wakeUpEarly(Rectangle characterHealth){
        this.setHealthLevel(this.getHealthLevel() - 10);
        new PlayerAnimations().updateHealthBar(characterHealth, 10).play();
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You didn't get enough rest lose 10 health points!");
        message.show();
    }

    public void waitForBus(ImageView bus, Rectangle joeHealth, ImageView joe){
        new PlayerAnimations().busAnimation(bus, joeHealth, joe).play();
        this.setHealthLevel(this.getHealthLevel() - 20);
        Alert warning = new Alert(Alert.AlertType.NONE, "The missed the bus and have to walk!  Lose 20 health points!", ButtonType.CLOSE );
        warning.show();
    }

   public void walkToWork(ImageView image, Rectangle joeHealth){
       new PlayerAnimations().walkToWork(image, joeHealth).play();
        this.setHealthLevel(this.getHealthLevel() - 10);
        Alert warning = new Alert(Alert.AlertType.NONE, "Already tired and you choose to walk?!  Lose 10 health points!", ButtonType.CLOSE );
        warning.show();
   }
}
