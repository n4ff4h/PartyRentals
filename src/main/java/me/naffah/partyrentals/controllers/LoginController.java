package me.naffah.partyrentals.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    protected void onLoginButtonClick() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Login Successful!");
        a.show();
    }
}