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

public class CharacterSelectionController {
    @FXML
    private Stage stage;
    private Scene scene;
    public static Player player;

    public static PlayerControl controls = new PlayerControl();
    @FXML
    private ImageView magiSprite;

    @FXML public void startGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("choose-character-scene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void createPlayer(ActionEvent event){
        //if event equals select Magi create Magi player;
        player = new Player();
        player.setMagi(new Magi("Magic", magiSprite));
        player.setPlayerHealth(player.getMagi().getHealthLevel());
        player.setPlayerHealthBar(new Rectangle());
    }

    @FXML public void startForestQuest(ActionEvent event) throws IOException {
        createPlayer(event);
        new ForestQuestOneController().startForestQuestSceneOne(event);
    }

}
