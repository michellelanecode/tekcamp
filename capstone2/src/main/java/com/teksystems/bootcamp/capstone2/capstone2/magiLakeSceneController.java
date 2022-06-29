package com.teksystems.bootcamp.capstone2.capstone2;


import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        Parent root = FXMLLoader.load(getClass().getResource("startFightScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void swim(){
        character.swim(characterImage);
        characterHealth.setWidth(character.getHealthTypeLevel());
    }
    public void jumpOver(){
        character.jumpOver(characterImage);
        characterHealth.setWidth(character.getHealthTypeLevel());

    }


}
