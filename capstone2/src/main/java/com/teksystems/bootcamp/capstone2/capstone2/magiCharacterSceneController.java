package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class magiCharacterSceneController {

    @FXML
    private Stage stage;
    @FXML
    private Magi character = ToBeHumaansMainController.getCharacter();
    private Scene scene;
    @FXML
    private Rectangle characterHealth;

    private static AudioClip sceneMusic = new AudioClip("https://vgmsite.com/soundtracks/pokemon-diamond-and-pearl-super-music-collection/fauztnlz/2-71%20Ending.mp3");

    public static AudioClip getSceneMusic() {
        return sceneMusic;
    }

    @FXML public void startForestQuest(ActionEvent event) throws IOException {
        ToBeHumaansMainController.getSceneMusic().stop();
        ToBeHumaans.playSelectionMusic();
        sceneMusic.setVolume(0.04);
        sceneMusic.play();
        characterHealth = new Rectangle();
        characterHealth.setWidth(character.getHealthTypeLevel());
        Parent root = FXMLLoader.load(getClass().getResource("forest-adventure-scene1.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
