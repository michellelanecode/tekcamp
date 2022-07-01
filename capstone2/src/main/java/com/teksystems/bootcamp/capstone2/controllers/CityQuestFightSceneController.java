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

public class CityQuestFightSceneController extends CityControllers implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerController.getNowPlaying().stop();
        playerController.setNowPlaying(new GameMusic().getCityBossScene());
        playerController.getNowPlaying().setCycleCount(Timeline.INDEFINITE);
        playerController.getNowPlaying().play();
        joeHealth.setWidth(joe.getHealthLevel());
        enemy = new Enemy();
        enemy.setEnemyJoe(joe);
    }

    @FXML public void attackCharacters() {
        int userDamage = joe.getDamagePoints();
        int userEnemyDamage = enemy.getDamagePoints();

        if (enemy.getHealthLevel() <= userDamage){
            joe.attack(joeSprite, enemySprite, enemyHealth, enemy);
            enemy.faint(enemyHealth, enemySprite, -90, enemy);
            attackButton.setDisable(true);
            showWinAlert();

        } else if (joe.getHealthLevel() <= userEnemyDamage) {
            enemy.attack(joeSprite, enemySprite, joeHealth);
            joe.faint(joeHealth, joeSprite, 90, enemy);
            attackButton.setDisable(true);
            showLoseAlert();
        } else {
            enemy.setHealthLevel(enemy.getHealthLevel() - userDamage);
            joe.setHealthLevel(joe.getHealthLevel() - userEnemyDamage);
            new PlayerAnimations().fight(joeSprite, enemySprite, joeHealth, enemyHealth, userDamage, userEnemyDamage).play();
        }
    }
    @FXML
    public void endGame(ActionEvent event) throws IOException, InterruptedException {
        playerController.triggerEndScene(event);
    }

}
