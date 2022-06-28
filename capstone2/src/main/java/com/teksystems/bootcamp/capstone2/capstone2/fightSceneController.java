package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.animation.FadeTransition;
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
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class fightSceneController implements Initializable {

    @FXML
    private Rectangle characterHealth = new Rectangle();
    @FXML
    private Rectangle enemyHealth = new Rectangle();
    @FXML
    private Text enemyHealthType;
    @FXML
    private Text characterHealthType;
    @FXML
    private ImageView enemySprite;
    @FXML
    private ImageView characterSprite;
    @FXML
    private Magi character = ToBeHumaansController.getCharacter();
    @FXML
    private Enemy enemy;

    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        enemy = new Enemy("Magic");
        enemyHealthType.setText("Magic");
        characterHealthType.setText("Magic");
        enemyHealth.setWidth(enemy.getHealthTypeLevel());
        characterHealth.setWidth(character.getHealthTypeLevel());
    }


    @FXML
    public void attack(ActionEvent event) throws IOException, InterruptedException {
        attackEnemy(enemy, event);
        animateHit(enemySprite);
        enemyHealth.setWidth(enemy.getHealthTypeLevel());
        attackCharacter(character, event);
        animateHit(characterSprite);
        characterHealth.setWidth(character.getHealthTypeLevel());
    }


    @FXML
    public void animateHit(ImageView target) {
        FadeTransition blink = new FadeTransition(Duration.millis(1000), target);
        blink.setFromValue(0.2);
        blink.setToValue(1.0);
        blink.setCycleCount(3);
        blink.play();
    }

    public void attackCharacter(Magi hero, ActionEvent event) throws IOException, InterruptedException {
        int characterHealth = hero.getHealthTypeLevel();
        int damagePoints = enemy.getDamagePoints();
        if (characterHealth <= damagePoints && (characterHealth > 0) ){
            character.faint();
            characterSprite.setImage(character.getCharacter());
        } else if ((characterHealth <= 0)){
            endGame(event);
        }
        character.setHealthTypeLevel(characterHealth - damagePoints);
    }

    public void attackEnemy(Enemy boss, ActionEvent event) throws IOException, InterruptedException {
        int enemyHealth = boss.getHealthTypeLevel();
        int damagePoints = character.getDamagePoints();
        if ((enemyHealth <= damagePoints) && (enemyHealth > 0)){
            enemy.faint();
            enemySprite.setImage(enemy.getEnemyImage());
        } else if ((enemyHealth <= 0)){
            endGame(event);
        }
        enemy.setHealthTypeLevel(enemyHealth - damagePoints);
    }


    @FXML public void endGame(ActionEvent event) throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(getClass().getResource("endGame.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
