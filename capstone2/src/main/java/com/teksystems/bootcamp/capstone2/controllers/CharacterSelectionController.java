package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CharacterSelectionController extends ToBeHumaansController {

    @FXML public void startGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choose-character-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void startForestQuest(ActionEvent event) throws IOException {
        playerController.getNowPlaying().stop();
        playerController.setNowPlaying(new GameMusic().getForestJourney());
        playerController.getNowPlaying().play();
        new ForestControllers().startForestQuestScene(event, "forest-adventure-scene1.fxml");
    }

    @FXML public void startCityQuest(ActionEvent event) throws IOException {
        playerController.getNowPlaying().stop();
        playerController.setNowPlaying(new GameMusic().getCityScene());
        playerController.getNowPlaying().play();
      new CityControllers().startCityQuestScene(event, "city-adventure-scene1.fxml");
    }
}
