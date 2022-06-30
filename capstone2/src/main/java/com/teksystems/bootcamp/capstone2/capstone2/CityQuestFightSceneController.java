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

public class CityQuestFightSceneController {


    @FXML
    private ImageView characterSprite;

    @FXML
    private ImageView enemySprite;



    @FXML
    public void startCityQuestFightScene(ActionEvent event) throws IOException {
        ToBeHumaans.controls.getNowPlaying().stop();
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-fight-scene.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void attack(ActionEvent event) {

    }
    @FXML
    public void endGame(ActionEvent event) throws IOException, InterruptedException {
        ToBeHumaans.controls.getNowPlaying().stop();
        ToBeHumaans.sceneMusic.getGameOver().play();
        ToBeHumaans.controls.endGame(event);
    }

}
