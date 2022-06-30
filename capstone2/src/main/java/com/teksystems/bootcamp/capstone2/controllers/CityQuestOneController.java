package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.characters.AvgJoe;
import com.teksystems.bootcamp.capstone2.player.PlayerInformation;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class CityQuestOneController {

    private PlayerInformation playerInformation = CharacterSelectionController.playerInformation;

    private final PlayerController playerControl = ToBeHumaansController.controls;
    private AvgJoe joe = playerInformation.getJoe();

    @FXML
    private Rectangle joeHealth = playerInformation.getPlayerHealthBar();;


    @FXML
    public void startCityQuest(ActionEvent event) throws IOException {
        playerControl.changeSong(ToBeHumaansController.sceneMusic.getCityScene2());
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-scene1.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void startCityQuestScene1(ActionEvent event) throws IOException {
        playerControl.changeSong(ToBeHumaansController.sceneMusic.getAlarmClock());
        playerControl.getNowPlaying().setCycleCount(Timeline.INDEFINITE);
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-scene2.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void sleepIn(ActionEvent event) {
        joe.sleepIn(playerInformation, joeHealth);

    }

    @FXML
    void wakeUpEarly(ActionEvent event) {
        joe.wakeUpEarly(playerInformation, joeHealth);

    }

    @FXML
    void startCityQuestScene2(ActionEvent event) throws IOException {
       playerControl.startCityQuestScene2(event);
    }


}
