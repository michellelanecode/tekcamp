package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.characters.Magi;
import com.teksystems.bootcamp.capstone2.player.PlayerInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ForestQuestOneController {

    private PlayerInformation playerInformation = CharacterSelectionController.playerInformation;

    private Magi magi = playerInformation.getMagi();
    @FXML
    private Rectangle characterHealth = playerInformation.getPlayerHealthBar();
    @FXML
    private ImageView characterSprite;

//    @FXML
//    private Button continueButton;
//set it to where buttons make sound upon hover or action here.
//    @FXML
//    private Button eatMushroomButton;
    @FXML
    private ImageView mushroom;



    @FXML public void startForestQuestSceneOne(ActionEvent event) throws IOException {
        ToBeHumaansController.controls.changeSong(ToBeHumaansController.sceneMusic.getForestJourney());
        Parent root = FXMLLoader.load(getClass().getResource("forest-adventure-scene1.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void animateEat(){
        magi.eatMushroom(characterSprite, mushroom);
        ToBeHumaansController.controls.changeSong(ToBeHumaansController.sceneMusic.getAteMushroom());
        playerInformation.updatePlayerHealth(characterHealth, 20);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You've lost 20 magic points because you ate a strange mushroom!");
        message.show();
    }
    @FXML public void startForestQuestSceneTwo(ActionEvent event) throws IOException {
        new ForestQuestTwoController().startForestQuestScene2(event);
    }

}
