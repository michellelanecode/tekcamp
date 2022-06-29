package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.animation.SequentialTransition;
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
        ToBeHumaans.controls.setNowPlaying(ToBeHumaans.sceneMusic.getBossBattleMusic());
        ToBeHumaans.controls.getNowPlaying().play();
        playerInformation.setEnemy(new Enemy("Magic", enemySprite));
        playerInformation.setEnemyHealth(playerInformation.getEnemy().getHealthLevel());
        enemy = playerInformation.getEnemy();
        playerInformation.setPlayerHealthBar(characterHealth);
        playerInformation.setEnemyHealthBar(enemyHealth);
//        enemyHealth.setWidth(player.g.getHealthTypeLevel());
//        characterHealth.setWidth(character.getHealthTypeLevel(
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
        if (enemy.getHealthLevel() <= magi.getDamagePoints()){
            SequentialTransition endTransition = new SequentialTransition();
            endTransition.getChildren().addAll(
                    magi.returnAttackAnimation(magiSprite, enemySprite, enemy, enemyHealth),
                    enemy.returnfaintAnimation(enemyHealth, enemySprite)
            );
            endTransition.setCycleCount(1);
            endTransition.play();
        } else if (magi.getHealthLevel() <= enemy.getDamagePoints()) {
            SequentialTransition endTransition = new SequentialTransition();
            endTransition.getChildren().addAll(
                    enemy.returnAttackAnimation(enemySprite, magiSprite, magi, characterHealth),
                    magi.returnfaintAnimation(characterHealth, magiSprite)
            );
            endTransition.setCycleCount(1);
            endTransition.play();

        } else {
                SequentialTransition sequentialTransition = new SequentialTransition();
                sequentialTransition.getChildren().addAll(
                        magi.returnAttackAnimation(magiSprite, enemySprite, enemy, enemyHealth),
                        enemy.returnAttackAnimation(enemySprite, magiSprite, magi, characterHealth)
                );
                sequentialTransition.setCycleCount(1);
                sequentialTransition.play();
                }

        }
    public void endGame(ActionEvent event) throws IOException, InterruptedException {
        ToBeHumaans.controls.getNowPlaying().stop();
        ToBeHumaans.sceneMusic.getGameOver().play();
        ToBeHumaans.controls.endGame(event);
    }

}
