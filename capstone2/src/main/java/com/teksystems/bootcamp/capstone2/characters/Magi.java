package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.player.PlayerAnimations;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Magi extends Character {

    public void eatMushroom(ImageView image, ImageView mushroom, Rectangle characterHealth) {
        this.setHealthLevel(this.getHealthLevel() - 15);
        new PlayerAnimations().eatMushroom(image, mushroom, characterHealth).play();
        Alert message = new Alert(Alert.AlertType.CONFIRMATION);
        message.setContentText("Your actions have consequences! You ate a strange mushroom at lose 15 magic points!");
        message.show();
    }

    public void swim(ImageView user, Rectangle characterHealth ) {
        this.setHealthLevel(this.getHealthLevel() - 15);
        new PlayerAnimations().swim(user, characterHealth).play();
        Alert message = new Alert(Alert.AlertType.CONFIRMATION);
        message.setContentText("You're swimming a huge lake! Lose 15 points");
        message.show();
    }


    public void jumpOver(ImageView user, Rectangle characterHealth) {
        this.setHealthLevel(this.getHealthLevel() - 25);
        new PlayerAnimations().jumpOver(user, characterHealth).play();
        Alert message = new Alert(Alert.AlertType.CONFIRMATION);
        message.setContentText("You tried to jump over and failed! Lose 25 points");
        message.show();
    }
}
