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

    public void triggerEndScene(ActionEvent event) throws IOException {
        new GameOverController().startGameOverScene(event);
    }
}
