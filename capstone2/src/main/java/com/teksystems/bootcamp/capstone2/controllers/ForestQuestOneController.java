package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ForestQuestOneController extends ForestControllers {

    public void startForestQuestScene(ActionEvent event) throws IOException {
    playerController.getNowPlaying().stop();
    playerController.setNowPlaying(new GameMusic().getForestJourney());
    playerController.getNowPlaying().play();
    super.startForestQuestScene(event, "forest-adventure-scene1.fxml");
    }
    @FXML public void animateEat(){
        magi.eatMushroom(characterSprite, mushroom, characterHealth);
        eatMushroomButton.setDisable(true);
    }
    @FXML public void startForestQuestSceneTwo(ActionEvent event) throws IOException {
        startForestQuestScene(event, "forest-adventure-scene2.fxml");
    }


}
