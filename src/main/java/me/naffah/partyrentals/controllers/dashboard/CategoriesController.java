package me.naffah.partyrentals.controllers.dashboard;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import me.naffah.partyrentals.services.CategoriesService;

import java.sql.SQLException;

public class CategoriesController {
    public VBox parentVBox;
    public TextField nameField;
    public TextField rentalRateField;

    public void onAddButtonClick() throws SQLException {
        String name = nameField.getText();
        double rentalRate = Double.parseDouble(rentalRateField.getText());

        CategoriesService categoriesService = new CategoriesService();
        categoriesService.add(name, rentalRate);
    }
}
