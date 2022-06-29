package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ForestQuestTwoController {


    private PlayerInformation playerInformation = CharacterSelectionController.playerInformation;;

    private Magi magi = playerInformation.getMagi();
    @FXML
    private Rectangle characterHealth = playerInformation.getPlayerHealthBar();

    @FXML
    private ImageView characterImage;


    @FXML public void startForestQuestScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("forest-adventure-scene2.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void swim(){
        magi.swim(characterImage);
        playerInformation.updatePlayerHealth(characterHealth, 10);
        Alert warning = new Alert(Alert.AlertType.NONE, "You swam across a huge lake?! That takes energy! Lose 10 health points!", ButtonType.CLOSE );
        warning.setX(566);
        warning.setY(285);
        warning.show();
    }
    public void jumpOver(){
        magi.jumpOver(characterImage);
        playerInformation.updatePlayerHealth(characterHealth, 30);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
        Alert warning = new Alert(Alert.AlertType.NONE, "You tried to jump over the lake?! Lose 30 health points!", ButtonType.CLOSE );
        warning.setX(566);
        warning.setY(285);
        warning.show();
    }

    public void startFightScene(ActionEvent event) throws IOException {
        ToBeHumaans.controls.getNowPlaying().stop();
        new ForestQuestFightSceneController().startFightScene(event);
    }

}
