package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.characters.Magi;
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
import java.util.Objects;
import java.util.ResourceBundle;

public class ForestQuestFightSceneController implements Initializable {

    private final PlayerInformation playerInformation = CharacterSelectionController.playerInformation;

    private final PlayerController playerControl = ToBeHumaansController.controls;

    private final Magi magi = playerInformation.getMagi();

    private Enemy enemy;
    @FXML
    private Rectangle characterHealth = playerInformation.getPlayerHealthBar();
    @FXML
    private Rectangle enemyHealth = playerInformation.getEnemyHealthBar();
    @FXML
    private ImageView magiSprite;
    @FXML
    private ImageView enemySprite;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerControl.changeSong(ToBeHumaansController.sceneMusic.getBossBattleMusic());
        playerControl.getNowPlaying().setCycleCount(Timeline.INDEFINITE);
        playerInformation.setEnemy(new Enemy());
        enemy = playerInformation.getEnemy();
        playerInformation.setEnemyHealth(playerInformation.getEnemy().getHealthLevel());
        enemy = playerInformation.getEnemy();
        playerInformation.setPlayerHealthBar(characterHealth);
        playerInformation.setEnemyHealthBar(enemyHealth);

    }
    @FXML
    public void startFightScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("forest-fight-scene.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void attack() {
        if (playerInformation.getEnemyHealth() <= magi.getDamagePoints()){
            SequentialTransition endTransition = new SequentialTransition();
            endTransition.getChildren().addAll(
                    magi.returnAttackAnimation(magiSprite, enemySprite, playerInformation),
                    enemy.returnfaintAnimation(enemyHealth, enemySprite)
            );
            endTransition.setCycleCount(1);
            endTransition.play();
            ToBeHumaansController.controls.changeSong(ToBeHumaansController.sceneMusic.getWonFight());
           
        } else if (playerInformation.getPlayerHealth() <= enemy.getDamagePoints()) {
            SequentialTransition endTransition = new SequentialTransition();
            endTransition.getChildren().addAll(
                    enemy.returnMagiAttackAnimation(enemySprite, magiSprite),
                    magi.returnfaintAnimation(characterHealth, magiSprite)
            );
            endTransition.setCycleCount(1);
            endTransition.play();
            ToBeHumaansController.controls.changeSong(ToBeHumaansController.sceneMusic.getLostFight());

        } else {
                SequentialTransition sequentialTransition = new SequentialTransition();
                sequentialTransition.getChildren().addAll(
                        magi.returnAttackAnimation(magiSprite, enemySprite, playerInformation),
                        enemy.returnMagiAttackAnimation(enemySprite, magiSprite)
                );
                sequentialTransition.setCycleCount(1);
                sequentialTransition.play();
                }

        }
    public void endGame(ActionEvent event) throws IOException, InterruptedException {
        playerControl.triggerEndScene(event);
    }
}
