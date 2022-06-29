package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.IOException;

public class ToBeHumaans extends Application {

    private static AudioClip sceneMusic;
    @Override
    public void start(Stage stage) throws IOException {
        sceneMusic = new AudioClip("https://soundimage.org/wp-content/uploads/2014/09/Our-Mountain_v003.mp3");
        sceneMusic.setVolume(0.02);
        sceneMusic.play();
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("To Be Humaan");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

    public static AudioClip getSceneMusic(){
        return sceneMusic;
    }

    public static void playSelectionMusic(){
        AudioClip selectionMusic = new AudioClip("https://vgmsite.com/soundtracks/nintendo-switch-sound-effects/cusagemg/Controller.mp3");
        selectionMusic.setVolume(.05);
        selectionMusic.play();
    }

}