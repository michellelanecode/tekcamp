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

    public static PlayerController controls = new PlayerController();
    public static GameMusic sceneMusic = new GameMusic();
    @Override
    public void start(Stage stage) throws IOException {
        controls.setNowPlaying(sceneMusic.getWelcomeSceneMusic());
        controls.getNowPlaying().play();
        Parent root = FXMLLoader.load(getClass().getResource("start-game.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("To Be Humaan");
        stage.setScene(scene);
        stage.show();
    }



    public void startCharacterSelection(ActionEvent event) throws IOException {
        new CharacterSelectionController().startGame(event);
    }

    public static void main(String[] args) {
        launch();
    }


}