package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.characters.AvgJoe;
import com.teksystems.bootcamp.capstone2.characters.Magi;
import com.teksystems.bootcamp.capstone2.player.PlayerInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CharacterSelectionController {

    public static PlayerInformation playerInformation;
    private final PlayerController playerControl = ToBeHumaansController.controls;
    @FXML public void startGame(ActionEvent event) throws IOException {
        playerControl.changeSong(ToBeHumaansController.sceneMusic.getForestJourney());
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-character-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML public void createPlayer(ActionEvent event){
        Button character = (Button) event.getSource();
        String characterChoice = character.getText();

        switch (characterChoice) {
            case "Select Magi" -> {
                playerInformation = new PlayerInformation();
                playerInformation.setMagi(new Magi());
                playerInformation.setPlayerHealth(playerInformation.getMagi().getHealthLevel());
                playerInformation.setPlayerHealthBar(new Rectangle());
            }
            case "Select Joe" -> {
                playerInformation = new PlayerInformation();
                playerInformation.setJoe(new AvgJoe());
                playerInformation.setPlayerHealth(playerInformation.getJoe().getHealthLevel());
                playerInformation.setPlayerHealthBar(new Rectangle());
            }
        }
    }

    @FXML public void startForestQuest(ActionEvent event) throws IOException {
        createPlayer(event);
        playerControl.startForestQuest(event);
    }

    @FXML public void startCityQuest(ActionEvent event) throws IOException {
        createPlayer(event);
        playerControl.startCityQuest(event);
    }
}
