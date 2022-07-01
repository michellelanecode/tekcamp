package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class CityQuestOneController extends CityControllers {



    @FXML
    public void startCityQuestScene1(ActionEvent event) throws IOException {
        playerController.getNowPlaying().stop();
        playerController.setNowPlaying(new GameMusic().getAlarmClock());
        playerController.getNowPlaying().setCycleCount(Timeline.INDEFINITE);
        playerController.getNowPlaying().play();
        super.startCityQuestScene(event, "city-adventure-scene2.fxml");
    }

    @FXML
    void sleepIn() {
        playerController.getNowPlaying().stop();
        joe.sleepIn(joeHealth);
        disableButtons();
    }

    @FXML
    void wakeUpEarly() {
        playerController.getNowPlaying().stop();
        joe.wakeUpEarly(joeHealth);
        disableButtons();
    }

    @FXML
    void startCityQuestScene2(ActionEvent event) throws IOException {
        playerController.getNowPlaying().stop();
        playerController.setNowPlaying(new GameMusic().getCityScene2());
        playerController.getNowPlaying().play();
       startCityQuestScene(event, "city-adventure-scene3.fxml");
    }

    private void disableButtons(){
        alarmButton.setDisable(true);
        snoozeButton.setDisable(true);
    }
}
