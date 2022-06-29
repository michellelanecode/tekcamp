package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ToBeHumaansMainController {
    @FXML
    private Stage stage;
    private static Magi character;
    private Scene scene;
    @FXML
    private ImageView characterSprite;
    @FXML
    private static Rectangle characterHealth = new Rectangle();

    private static AudioClip sceneMusic = new AudioClip("https://vgmsite.com/soundtracks/pokemon-emerald-enhanced-soundtrack/bxhqoubsyx/1-05%20Littleroot%20Town.mp3");
    @FXML public void switchToCharacterScene(ActionEvent event) throws IOException {
        ToBeHumaans.getSceneMusic().stop();
        ToBeHumaans.playSelectionMusic();
        sceneMusic.setVolume(0.03);
        sceneMusic.play();
        character = new Magi("Magic", characterSprite);
        Parent root = FXMLLoader.load(getClass().getResource("choose-character-scene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static Magi getCharacter(){
        return character;
    }

    public static AudioClip getSceneMusic(){
        return sceneMusic;
    }
}
