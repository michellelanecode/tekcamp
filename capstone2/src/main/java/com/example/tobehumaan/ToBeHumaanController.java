package com.example.tobehumaan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ToBeHumaanController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}