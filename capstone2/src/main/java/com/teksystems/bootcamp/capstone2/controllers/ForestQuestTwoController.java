package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.characters.Magi;
import com.teksystems.bootcamp.capstone2.player.PlayerInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ForestQuestTwoController {
    private final PlayerInformation playerInformation = CharacterSelectionController.playerInformation;
    private final PlayerController playerControl = ToBeHumaansController.controls;
    private final Magi magi = playerInformation.getMagi();
    @FXML private Rectangle characterHealth = playerInformation.getPlayerHealthBar();
    @FXML private ImageView characterImage;
    @FXML public void startForestQuestScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("forest-adventure-scene2.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML public void swim(){
        magi.swim(characterImage, characterHealth);
    }
    @FXML public void jumpOver(){
        magi.jumpOver(characterImage, characterHealth);
    }

    public void startForestFightScene(ActionEvent event) throws IOException {
       playerControl.startForestFightScene(event);
    }

}
