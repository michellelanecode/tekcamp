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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForestQuestFightSceneController implements Initializable {

    private final Player player = CharacterSelectionController.player;;

    private final Magi magi = player.getMagi();

    private Enemy enemy;
    @FXML
    private Rectangle characterHealth = player.getPlayerHealthBar();
    @FXML
    private Rectangle enemyHealth = player.getEnemyHealthBar();
    @FXML
    private ImageView characterSprite;
    @FXML
    private ImageView enemySprite;

    @FXML
    private Text enemyHP;

    @FXML
    private Text playerHP;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player.setEnemy(new Enemy("Magic", enemySprite));
        player.setEnemyHealth(player.getEnemy().getHealthLevel());
        enemy = player.getEnemy();
        playerHP.setText(Integer.toString(player.getPlayerHealth()));
        enemyHP.setText(Integer.toString(player.getEnemyHealth()));
//        enemyHealth.setWidth(player.g.getHealthTypeLevel());
//        characterHealth.setWidth(character.getHealthTypeLevel(
    }
    @FXML
    public void startFightScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("forest-fight-scene.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void attack() {
        if (enemy.getHealthTypeLevel() <= magi.getDamagePoints()){
            SequentialTransition endTransition = new SequentialTransition();
            endTransition.getChildren().addAll(
                    magi.returnAttackAnimation(characterSprite, enemySprite, enemy, enemyHealth),
                    enemy.returnfaintAnimation(enemyHealth)
            );
            endTransition.setCycleCount(1);
            endTransition.play();
            enemyHP.setText(Integer.toString(player.getEnemyHealth()));
        } else {
            SequentialTransition sequentialTransition = new SequentialTransition();
            sequentialTransition.getChildren().addAll(
                    magi.returnAttackAnimation(characterSprite, enemySprite, enemy, enemyHealth),
                    enemy.returnAttackAnimation(enemySprite, characterSprite, magi, characterHealth)
            );
            sequentialTransition.setCycleCount(1);
            sequentialTransition.play();
            playerHP.setText(Integer.toString(player.getPlayerHealth()));
            enemyHP.setText(Integer.toString(player.getEnemyHealth()));
        }
        }
    public void endGame(ActionEvent event) throws IOException, InterruptedException {
        CharacterSelectionController.controls.endGame(event);
    }

}
