package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class fightSceneController implements Initializable {

    @FXML
    private Text characterHealth;
    @FXML private Text enemyHealth;
    @FXML private Text enemyHealthType;
    @FXML private Text characterHealthType;

    @FXML private Magi character;
    @FXML private Enemy enemy;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = new Magi();
        enemy = new Enemy("magic");
        enemyHealthType.setText("Magic");
        enemyHealth.setText(enemy.getHealthTypeLevel().toString());
        characterHealthType.setText("Magic");
        characterHealth.setText(character.getHealthTypeLevel().toString());
    }


    @FXML public void attack(ActionEvent event) throws InterruptedException {
        character.castSpell(enemy);
        Thread.sleep(2000);
        enemy.attack(character);
    }


    @FXML public void checkChoices(){

    }
}
