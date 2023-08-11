package me.naffah.partyrentals.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import me.naffah.partyrentals.services.AuthService;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    public void onLoginButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        Alert a = new Alert(Alert.AlertType.ERROR);

        AuthService authService = new AuthService();
        boolean authStatus = authService.authenticate(username, password);

        if (authStatus) {
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Login Successful!");
            a.show();
        } else {
            a.setContentText("Authentication Failed!");
            a.show();
        }

    }
}