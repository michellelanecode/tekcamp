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


    //find alarm sound to play during this scene and find a yell sound to play if you choose to wakeup early
    // wakeup early takes away 10 health due to still being tired
    // sleep in takes away 25 health due to being late


    @FXML
    void sleepIn(ActionEvent event) {

    }

    @FXML
    void wakeUpEarly(ActionEvent event) {

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
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-scene2.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void startCityQuestScene2(ActionEvent event) throws IOException {
        new CityQuestTwoController().startCityQuestScene3(event);
    }


}
