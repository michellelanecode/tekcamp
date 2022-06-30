package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.characters.AvgJoe;
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

public class CityQuestTwoController {

    private final PlayerController playerControl = ToBeHumaansController.controls;
    private final PlayerInformation playerInformation = CharacterSelectionController.playerInformation;

    private final AvgJoe joe = playerInformation.getJoe();
    @FXML
    private Rectangle joeHealth = playerInformation.getPlayerHealthBar();

    @FXML
    private ImageView joeSprite;

    @FXML
    private ImageView spriteBus;

    @FXML
    public void startCityQuestScene3(ActionEvent event) throws IOException {
        playerControl.changeSong(ToBeHumaansController.sceneMusic.getCityScene2());
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("city-adventure-scene3.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void waitForBus() {
        joe.waitForBus(spriteBus, joeHealth);

    }

    @FXML
    void walkToWork() {
        joe.walkToWork(joeSprite, joeHealth);

    }

    @FXML
    void startCityFightScene(ActionEvent event) throws IOException {
    playerControl.startCityFightScene(event);
    }

}
