package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ToBeHumaansController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        System.out.println("This is working");
    }
}