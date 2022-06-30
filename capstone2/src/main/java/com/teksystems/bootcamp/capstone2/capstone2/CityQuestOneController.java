package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.AvgJoe;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class CityQuestOneController {

    private PlayerInformation playerInformation = CharacterSelectionController.playerInformation;

    private AvgJoe joe = playerInformation.getJoe();

    @FXML
    private Rectangle joeHealth = playerInformation.getPlayerHealthBar();;

    @FXML
    void sleepIn(ActionEvent event) {
        joe.sleepIn(playerInformation, joeHealth);
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You're gonna be late lose 25 health points!");
        message.show();
    }

    @FXML
    void wakeUpEarly(ActionEvent event) {
        joe.wakeUpEarly(playerInformation, joeHealth);
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You didn't get enough rest lose 10 health points!");
        message.show();
    }


    @FXML
    public void startCityQuest(ActionEvent event) throws IOException {
        ToBeHumaans.controls.getNowPlaying().stop();
        ToBeHumaans.controls.setNowPlaying(ToBeHumaans.sceneMusic.getCityScene());
        ToBeHumaans.controls.getNowPlaying().play();
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-scene1.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void startCityQuestScene1(ActionEvent event) throws IOException {
        ToBeHumaans.controls.getNowPlaying().stop();
        ToBeHumaans.controls.setNowPlaying(ToBeHumaans.sceneMusic.getAlarmClock());
        ToBeHumaans.controls.getNowPlaying().setCycleCount(Timeline.INDEFINITE);
        ToBeHumaans.controls.getNowPlaying().play();
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-scene2.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void startCityQuestScene2(ActionEvent event) throws IOException {
        ToBeHumaans.controls.getNowPlaying().stop();
        new CityQuestTwoController().startCityQuestScene3(event);
    }


}
