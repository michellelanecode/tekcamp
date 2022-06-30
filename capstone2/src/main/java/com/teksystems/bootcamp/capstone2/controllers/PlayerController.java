package com.teksystems.bootcamp.capstone2.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;

public class PlayerController {
    private MediaPlayer nowPlaying;
    @FXML
    public void endGame() {
       Platform.exit();
    }

    public void startGame(ActionEvent event) throws IOException {
        new CharacterSelectionController().startGame(event);
    }

    public MediaPlayer getNowPlaying() {
        nowPlaying.setVolume(0.04);
        return nowPlaying;
    }

    public void setNowPlaying(MediaPlayer nowPlaying) {
        this.nowPlaying = nowPlaying;
    }

    public void changeSong(MediaPlayer newSong){
        this.getNowPlaying().stop();
        this.setNowPlaying(newSong);
        this.nowPlaying.setCycleCount(1);
        this.getNowPlaying().play();
    }

    public String getChoice(ActionEvent event){
        Button choice = (Button) event.getSource();
        String gamePlayChoice = choice.getText();
        return gamePlayChoice;
    }

    public void startCharacterSelection(ActionEvent event) throws IOException {
        new CharacterSelectionController().startGame(event);
    }

    @FXML public void startForestQuest(ActionEvent event) throws IOException {
        new ForestQuestOneController().startForestQuestSceneOne(event);
    }

    @FXML public void startCityQuest(ActionEvent event) throws IOException {
        new CityQuestOneController().startCityQuest(event);
    }

   public void startCityFightScene(ActionEvent event) throws IOException {
        new CityQuestFightSceneController().startCityQuestFightScene(event);
    }

    public void startForestFightScene(ActionEvent event) throws IOException {
        new ForestQuestFightSceneController().startFightScene(event);
    }

    public void startCityQuestScene2(ActionEvent event) throws IOException {
        new CityQuestTwoController().startCityQuestScene3(event);
    }

    @FXML public void startForestQuestSceneTwo(ActionEvent event) throws IOException {
        new ForestQuestTwoController().startForestQuestScene2(event);
    }

    public void triggerEndScene(ActionEvent event) throws IOException {
        new GameOverController().startGameOverScene(event);
    }


}
