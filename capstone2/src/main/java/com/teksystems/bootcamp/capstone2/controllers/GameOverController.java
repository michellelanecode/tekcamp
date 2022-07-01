package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController {
    public PlayerController playerController = ToBeHumaansController.playerController;

    public void startGameOverScene(ActionEvent event) throws IOException {
        playerController.getNowPlaying().stop();
        playerController.setNowPlaying(new GameMusic().getGameOver());
        playerController.getNowPlaying().play();
        Parent root = FXMLLoader.load(getClass().getResource("endGame.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void startNewGame(ActionEvent event) throws IOException {
        playerController.startGame(event);
    }

    public void endGame(){
        playerController.endGame();
    }

}
