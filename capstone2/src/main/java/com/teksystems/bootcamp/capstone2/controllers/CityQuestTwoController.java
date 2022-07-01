package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CityQuestTwoController extends CityControllers implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        joeHealth.setWidth(joe.getHealthLevel());
    }

    @FXML
    void waitForBus() {
        playerController.getNowPlaying().stop();
        playerController.changeSong(new GameMusic().getMissedBus());
        joe.waitForBus(spriteBus, joeHealth, joeSprite);
        disableButtons();
    }

    @FXML
    void walkToWork() {
        playerController.getNowPlaying().stop();
        playerController.changeSong(new GameMusic().getJumpSound());
        joe.walkToWork(joeSprite, joeHealth);
        disableButtons();
    }

    @FXML
    void startCityFightScene(ActionEvent event) throws IOException {
        startCityQuestScene(event, "city-adventure-fight-scene.fxml");
    }

    public void disableButtons(){
        walkButton.setDisable(true);
        busButton.setDisable(true);
    }
}
