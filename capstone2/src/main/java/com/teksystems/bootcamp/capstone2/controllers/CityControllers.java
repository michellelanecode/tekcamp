package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import com.teksystems.bootcamp.capstone2.characters.AvgJoe;
import com.teksystems.bootcamp.capstone2.characters.Enemy;
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
import java.util.Objects;

public class CityControllers {

    protected  PlayerController playerController = ToBeHumaansController.playerController;

    protected AvgJoe joe = ToBeHumaansController.playerController.getUserJoe();

    @FXML
    protected Button attackButton;

    @FXML
    protected Button snoozeButton;

    @FXML
    protected Button busButton;

    @FXML
    protected Button walkButton;
    @FXML
    protected Button alarmButton;
    @FXML protected ImageView joeSprite;

    @FXML protected Rectangle joeHealth;

    protected Enemy enemy;
    @FXML protected Rectangle enemyHealth;

    @FXML protected ImageView enemySprite;

    @FXML protected ImageView spriteBus;
    @FXML protected void startCityQuestScene (ActionEvent event, String path) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(path)));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    protected void showLoseAlert(){
        playerController.getNowPlaying().stop();
        playerController.setNowPlaying(new GameMusic().getLostFight());
        playerController.getNowPlaying().play();
        Alert lose = new Alert(Alert.AlertType.CONFIRMATION);
        lose.setContentText("You LOSE!");
        lose.show();
    }

    protected void showWinAlert(){
        playerController.getNowPlaying().stop();
        playerController.setNowPlaying(new GameMusic().getWonFight());
        playerController.getNowPlaying().play();
        Alert win = new Alert(Alert.AlertType.CONFIRMATION);
        win.setContentText("You WIN!");
        win.show();
    }

}
