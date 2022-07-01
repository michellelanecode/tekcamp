package com.teksystems.bootcamp.capstone2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForestQuestTwoController extends ForestControllers implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        characterHealth.setWidth(magi.getHealthLevel());
    }
    @FXML public void swim(){
        magi.swim(characterSprite, characterHealth);
        disableButtons();
    }
    @FXML public void jumpOver(){
        magi.jumpOver(characterSprite, characterHealth);
        disableButtons();
    }

    public void startForestFightScene(ActionEvent event) throws IOException {
        super.startForestQuestScene(event, "forest-fight-scene.fxml");
    }


}
