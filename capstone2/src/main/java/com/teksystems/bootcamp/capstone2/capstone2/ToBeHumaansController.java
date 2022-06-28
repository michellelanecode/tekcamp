package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ToBeHumaansController {


    @FXML
    private Stage stage;

    private static Magi character;
    private Scene scene;

    @FXML
    private ImageView mushroom;

    @FXML
    private Rectangle characterHealth = new Rectangle();


    @FXML public void switchToCharacterScene(ActionEvent event) throws IOException {
        character = new Magi();
        Parent root = FXMLLoader.load(getClass().getResource("characterscene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML public void startForestQuest(ActionEvent event) throws IOException {

        characterHealth.setWidth(character.getHealthTypeLevel());
        Parent root = FXMLLoader.load(getClass().getResource("forest1.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML public void startForestQuestPt2(ActionEvent event) throws IOException, InterruptedException {
        characterHealth.setWidth(character.getHealthTypeLevel());
        Parent root = FXMLLoader.load(getClass().getResource("forest2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML public void startFightScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("startFightScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML public void animateEat(ActionEvent event){
        character.eatMushroom();
        characterHealth.setWidth(character.getHealthTypeLevel());
        FadeTransition blink = new FadeTransition(Duration.millis(1000), mushroom);
        blink.setFromValue(1.0);
        blink.setToValue(0);
        blink.setCycleCount(4);
        blink.play();
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You've lost 20 magic points because you ate a strange mushroom!");
        message.show();

    }
    public void swim(){
        character.swim();
        characterHealth.setWidth(character.getHealthTypeLevel());
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You've lost 20 health because you swam across a huge lake draining your energy!");
        message.show();
    }
    public void walkAround(){
        character.walkAround();
        characterHealth.setWidth(character.getHealthTypeLevel());
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You've lost 10 health from walking 10 miles around the lake");
        message.show();
    }
    public static Magi getCharacter(){
        return character;
    }

}
