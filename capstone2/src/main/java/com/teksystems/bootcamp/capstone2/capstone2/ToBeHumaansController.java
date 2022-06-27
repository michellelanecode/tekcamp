package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ToBeHumaansController {
    @FXML
    private Stage stage;
    private Parent root;
    private Scene scene;
    private int health;

    @FXML private Text characterHealth;
    @FXML private Text enemyHealth;
    @FXML private Text enemyHealthType;
    @FXML private Text characterHealthType;

    @FXML private Magi character;
    @FXML private Enemy enemy;

    public void initializeBattle() {
        character = new Magi();
        enemy = new Enemy("magic");
        enemyHealthType.setText("Magic");
        enemyHealth.setText(enemy.getHealthTypeLevel().toString());
        characterHealthType.setText("Magic");
        characterHealth.setText(character.getHealthTypeLevel().toString());
    }
@FXML
    public void switchToCharacterScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("characterscene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

@FXML
    public void startForestQuest(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("forest1.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void startForestQuestPt2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("forest2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void startForestQuestPt3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("forest3.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        initializeBattle();
    }

    @FXML public void attackEnemy(ActionEvent event) {

    }

    @FXML public void attackCharacter(ActionEvent event){

    }

    @FXML public void checkChoices(){
       
    }

}
