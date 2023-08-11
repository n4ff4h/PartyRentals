package me.naffah.partyrentals;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.naffah.partyrentals.services.DBService;

import java.io.IOException;
import java.sql.Connection;

public class PartyRentalsApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PartyRentalsApp.class.getResource("views/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Party Rentals App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DBService dbService = new DBService();
        Connection conn = dbService.connect();
        dbService.createTables(conn);

        launch(args);
    }
}