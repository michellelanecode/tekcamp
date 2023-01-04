package com.teksystems.bootcamp.capstone2.controllers;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.player.PlayerAnimations;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForestQuestFightSceneController extends ForestControllers implements Initializable {


    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerController.getNowPlaying().stop();
        playerController.setNowPlaying(new GameMusic().getBossBattleMusic());
        playerController.getNowPlaying().setCycleCount(Timeline.INDEFINITE);
        playerController.getNowPlaying().play();
        enemy = new Enemy();
        enemy.setEnemyMagi(magi);

        characterHealth.setWidth(magi.getHealthLevel());
    }

    @FXML
    public void fight() {
        int userDamage = magi.getDamagePoints();
        int userEnemyDamage = enemy.getDamagePoints();
        if (enemy.getHealthLevel() <= userDamage){
            magi.attack(characterSprite, enemySprite, enemyHealth, enemy);
            enemy.faint(enemyHealth, enemySprite, -90, enemy);
            attackButton.setDisable(true);
            showWinAlert();
            playerController.getNowPlaying().stop();
            playerController.setNowPlaying(new GameMusic().getWonFight());
            playerController.getNowPlaying().play();

        } else if (magi.getHealthLevel() <= userEnemyDamage) {
            enemy.attack(characterSprite, enemySprite, characterHealth);
            magi.faint(characterHealth, characterSprite, 90, enemy);
            attackButton.setDisable(true);
            showLoseAlert();
            playerController.getNowPlaying().stop();
            playerController.setNowPlaying(new GameMusic().getLostFight());
            playerController.getNowPlaying().play();
        } else {
            enemy.setHealthLevel(enemy.getHealthLevel() - userDamage);
            magi.setHealthLevel(magi.getHealthLevel() - userEnemyDamage);
            new PlayerAnimations().fight(characterSprite, enemySprite, characterHealth, enemyHealth, userDamage, userEnemyDamage).play();
        }
    }
    public void endGame(ActionEvent event) throws IOException, InterruptedException {
        new PlayerController().triggerEndScene(event);
    }
}
