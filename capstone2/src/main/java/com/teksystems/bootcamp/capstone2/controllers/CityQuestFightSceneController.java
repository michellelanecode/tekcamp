package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import com.teksystems.bootcamp.capstone2.characters.AvgJoe;
import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.player.PlayerInformation;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CityQuestFightSceneController implements Initializable {

    private final PlayerInformation playerInformation = CharacterSelectionController.playerInformation;

    private final AvgJoe joe = playerInformation.getJoe();

    private Enemy enemy;
    @FXML
    private Rectangle enemyHealth = playerInformation.getEnemyHealthBar();

    @FXML
    private ImageView enemySprite;

    @FXML
    private Rectangle joeHealth = playerInformation.getPlayerHealthBar();

    @FXML
    private ImageView joeSprite;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToBeHumaans.controls.changeSong(new GameMusic().getCityScene());
        ToBeHumaans.controls.getNowPlaying().setCycleCount(Timeline.INDEFINITE);
        playerInformation.setEnemy(new Enemy());
        playerInformation.setEnemyHealth(playerInformation.getEnemy().getHealthLevel());
        enemy = playerInformation.getEnemy();
        playerInformation.setPlayerHealthBar(joeHealth);
        playerInformation.setEnemyHealthBar(enemyHealth);

    }
    @FXML
    public void startCityQuestFightScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("city-adventure-fight-scene.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void attackCharacters() {
        if (playerInformation.getEnemyHealth() <= joe.getDamagePoints()){
            SequentialTransition endTransition = new SequentialTransition();
            endTransition.getChildren().addAll(
                    joe.returnAttackAnimation(joeSprite, enemySprite, playerInformation),
                    enemy.returnfaintAnimation(enemyHealth, enemySprite)
            );
            endTransition.setCycleCount(1);
            endTransition.play();
            ToBeHumaans.controls.changeSong(new GameMusic().getWonFight());
        } else if (playerInformation.getPlayerHealth() <= enemy.getDamagePoints()) {
            SequentialTransition endTransition = new SequentialTransition();
            endTransition.getChildren().addAll(
                    enemy.returnJoeAttackAnimation(enemySprite, joeSprite),
                    joe.returnfaintAnimation(joeHealth, joeSprite)
            );
            endTransition.setCycleCount(1);
            endTransition.play();
            ToBeHumaans.controls.changeSong(new GameMusic().getLostFight());
        } else {
            SequentialTransition sequentialTransition = new SequentialTransition();
            sequentialTransition.getChildren().addAll(
                    joe.returnAttackAnimation(joeSprite, enemySprite, playerInformation),
                    enemy.returnJoeAttackAnimation(enemySprite, joeSprite)
            );
            sequentialTransition.setCycleCount(1);
            sequentialTransition.play();
        }
    }
    @FXML
    public void endGame(ActionEvent event) throws IOException, InterruptedException {
        ToBeHumaans.controls.changeSong(new GameMusic().getGameOver());
        ToBeHumaans.controls.triggerEndScene(event);
    }

}
