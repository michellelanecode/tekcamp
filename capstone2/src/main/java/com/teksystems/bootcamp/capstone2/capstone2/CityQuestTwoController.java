package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CityQuestTwoController {

    @FXML
    private ImageView joeSprite;


    @FXML
    void waitForBus(ActionEvent event) {

    }

    @FXML
    void walkToWork(ActionEvent event) {

    }

    @FXML
    public void startCityQuestScene3(ActionEvent event) throws IOException {
        ToBeHumaans.controls.getNowPlaying().stop();
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-scene3.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void startCityFightScene(ActionEvent event) throws IOException {
    new CityQuestFightSceneController().startCityQuestFightScene(event);
    }

}
