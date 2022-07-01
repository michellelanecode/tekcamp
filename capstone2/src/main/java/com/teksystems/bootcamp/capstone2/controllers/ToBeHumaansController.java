package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToBeHumaansController extends Application {

    public static PlayerController playerController = new PlayerController();

    public GameMusic sceneMusic = new GameMusic();

    public void start(Stage stage) throws IOException {
        playerController.setNowPlaying(sceneMusic.getWelcomeSceneMusic());
        playerController.getNowPlaying().play();
        Parent root = FXMLLoader.load(getClass().getResource("start-game.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("To Be Humaan");
        stage.setScene(scene);
        stage.show();
    }

    public void startGame(ActionEvent event) throws IOException {
        playerController.startCharacterSelection(event);
    }

   public static void main(String[] args) {
        launch();
    }

}