package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.AvgJoe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CityQuestTwoController {

    private final PlayerInformation playerInformation = CharacterSelectionController.playerInformation;

    private final AvgJoe joe = playerInformation.getJoe();
    @FXML
    private Rectangle joeHealth = playerInformation.getPlayerHealthBar();

    @FXML
    private ImageView joeSprite;

    @FXML
    private ImageView spriteBus;

    @FXML
    void waitForBus() {
        joe.waitForBus(spriteBus);
        ToBeHumaans.controls.changeSong(new GameMusic().getMissedBus());
        playerInformation.updatePlayerHealth(joeHealth, 20);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
        Alert warning = new Alert(Alert.AlertType.NONE, "The missed the bus and have to walk!  Lose 20 health points!", ButtonType.CLOSE );
        warning.show();
    }

    @FXML
    void walkToWork() {
        joe.walkToWork(joeSprite);
        ToBeHumaans.controls.changeSong(new GameMusic().getJumpSound());
        playerInformation.updatePlayerHealth(joeHealth, 10);
        playerInformation.setPlayerHealthBar(playerInformation.getPlayerHealthBar());
        Alert warning = new Alert(Alert.AlertType.NONE, "Already tired and you choose to walk?!  Lose 10 health points!", ButtonType.CLOSE );
        warning.show();
    }

    @FXML
    public void startCityQuestScene3(ActionEvent event) throws IOException {
        ToBeHumaans.controls.changeSong(new GameMusic().getCityScene2());
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("city-adventure-scene3.fxml")));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void startCityFightScene(ActionEvent event) throws IOException {
    new CityQuestFightSceneController().startCityQuestFightScene(event);
    }

}
