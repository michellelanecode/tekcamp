package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class magiForestSceneController {
    @FXML
    private Rectangle characterHealth;

    @FXML
    private ImageView characterSprite;

    @FXML
    private Text healthType;

    @FXML
    private ImageView mushroom;


    private static final Magi character = ToBeHumaansMainController.getCharacter();

    @FXML public void startForestQuestPt2(ActionEvent event) throws IOException {
        characterHealth = new Rectangle();
        characterHealth.setWidth(character.getHealthTypeLevel());
        Parent root = FXMLLoader.load(getClass().getResource("forest-adventure-scene2.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void animateEat(){
        character.eatMushroom(characterSprite, mushroom);
        characterHealth.setWidth(character.getHealthTypeLevel());
        Alert message = new Alert(Alert.AlertType.WARNING);
        message.setContentText("You actions have consequences! You've lost 20 magic points because you ate a strange mushroom!");
        message.show();

    }
}
