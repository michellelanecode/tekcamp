package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class ToBeHumaansController {


    @FXML
    private Stage stage;

    private static Magi character;
    private Scene scene;

    @FXML
    private ImageView mushroom;
    @FXML
    private ImageView characterSprite;
    @FXML
    private static Rectangle characterHealth = new Rectangle();


    @FXML public void switchToCharacterScene(ActionEvent event) throws IOException {
        character = new Magi("Magic", characterSprite);
        Parent root = FXMLLoader.load(getClass().getResource("characterscene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("spriteStyles.css");
        stage.setScene(scene);
        stage.show();
    }


    public static Magi getCharacter(){
        return character;
    }

    public static Rectangle getCharacterHealth() {
        return characterHealth;
    }
}
