package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.AvgJoe;
import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class CharacterSelectionController {
    @FXML
    private Stage stage;
    private Scene scene;
    public static PlayerInformation playerInformation;
    @FXML
    private ImageView magiSprite;

    @FXML
    private ImageView joeSprite;

    @FXML public void startGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("choose-character-scene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void playSelectionSound(){
        ToBeHumaans.sceneMusic.getSelectionSound().play();
    }

    @FXML public void createPlayer(ActionEvent event){
        Button character = (Button) event.getSource();
        String characterChoice = character.getText();

        switch(characterChoice){
            case "Select Magi":
                playerInformation = new PlayerInformation();
                playerInformation.setMagi(new Magi("Magic", magiSprite));
                playerInformation.setPlayerHealth(playerInformation.getMagi().getHealthLevel());
                playerInformation.setPlayerHealthBar(new Rectangle());
                break;

            case "Select Joe":
                playerInformation = new PlayerInformation();
                playerInformation.setJoe(new AvgJoe("Fight", joeSprite));
                playerInformation.setPlayerHealth(playerInformation.getJoe().getHealthLevel());
                playerInformation.setPlayerHealthBar(new Rectangle());
        }
    }

    @FXML public void startForestQuest(ActionEvent event) throws IOException {
        createPlayer(event);
        ToBeHumaans.controls.getNowPlaying().stop();
        new ForestQuestOneController().startForestQuestSceneOne(event);
    }

    @FXML public void startCityQuest(ActionEvent event) throws IOException {
        createPlayer(event);
        ToBeHumaans.controls.getNowPlaying().stop();
        new CityQuestOneController().startCityQuest(event);
    }
}
