package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ForestControllers {

    protected  PlayerController playerController = ToBeHumaansController.playerController;

    protected Magi magi = ToBeHumaansController.playerController.getUserMagi();

    @FXML
    protected Button swimButton;

    @FXML
    protected Button eatMushroomButton;
    @FXML
    protected Button jumpButton;
    protected Enemy enemy;
    @FXML
    protected Rectangle characterHealth;

    @FXML
    protected Button attackButton;
    @FXML
    protected Rectangle enemyHealth;
    @FXML
    protected ImageView characterSprite;
    @FXML
    protected ImageView enemySprite;
    @FXML
    protected ImageView mushroom;
    @FXML
    public void startForestQuestScene(ActionEvent event, String scenePath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(scenePath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    protected void showLoseAlert(){
        Alert lose = new Alert(Alert.AlertType.CONFIRMATION);
        lose.setContentText("You LOSE!");
        lose.show();
    }

    protected void showWinAlert(){
        Alert win = new Alert(Alert.AlertType.CONFIRMATION);
        win.setContentText("You WIN!");
        win.show();
    }

    public void disableButtons(){
        jumpButton.setDisable(true);
        swimButton.setDisable(true);
    }
}

