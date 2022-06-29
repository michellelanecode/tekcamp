package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CityQuestOneController {

    @FXML
    public void startCityQuest(ActionEvent event) throws IOException {
        ToBeHumaans.controls.getNowPlaying().stop();
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-scene1.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void startCityQuestScene2(ActionEvent event) throws IOException {
        ToBeHumaans.controls.getNowPlaying().stop();
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-scene2.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
