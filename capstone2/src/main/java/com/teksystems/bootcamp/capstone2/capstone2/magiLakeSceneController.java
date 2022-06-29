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

public class magiLakeSceneController {
    @FXML
    private Stage stage;

    @FXML
    private Magi character = ToBeHumaansMainController.getCharacter();

    @FXML
    private ImageView characterImage;
    private Scene scene;

    @FXML
    private ImageView mushroom;

    @FXML
    private Rectangle characterHealth;

    @FXML
    public void startFightScene(ActionEvent event) throws IOException {
        characterHealth = new Rectangle();
        characterHealth.setWidth(character.getHealthTypeLevel());
        Parent root = FXMLLoader.load(getClass().getResource("forest-fight-scene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void swim(){
        character.swim(characterImage);
        characterHealth.setWidth(character.getHealthTypeLevel());
        Alert warning = new Alert(Alert.AlertType.NONE, "You swam across a huge lake?! That takes energy! Lose 10 health points!", ButtonType.CLOSE );
        warning.setX(366);
        warning.setY(185);
        warning.show();
    }
    public void jumpOver(){
        character.jumpOver(characterImage);
        characterHealth.setWidth(character.getHealthTypeLevel());
        Alert warning = new Alert(Alert.AlertType.NONE, "You tried to jump over the lake?! Lose 30 health points!", ButtonType.CLOSE );
        warning.setX(366);
        warning.setY(185);
        warning.show();
    }


}
