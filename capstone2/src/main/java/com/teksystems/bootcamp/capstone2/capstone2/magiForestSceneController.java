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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class magiForestSceneController {
    @FXML
    private Rectangle characterHealth;

    @FXML
    private ImageView characterSprite;

    @FXML
    private Button continueButton;

    @FXML
    private Button eatMushroomButton;

    @FXML
    private Text healthType;

    @FXML
    private ImageView mushroom;


    private static final Magi character = ToBeHumaansMainController.getCharacter();

    @FXML public void startForestQuestPt2(ActionEvent event) throws IOException {
        characterHealth = new Rectangle();
        characterHealth.setWidth(character.getHealthTypeLevel());
        Parent root = FXMLLoader.load(getClass().getResource("forest2.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void animateEat(){
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
}
