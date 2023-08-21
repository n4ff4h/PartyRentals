package me.naffah.partyrentals.controllers.dashboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import me.naffah.partyrentals.models.Category;
import me.naffah.partyrentals.services.CategoriesService;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CategoriesController implements Initializable {
    public VBox parentVBox;
    public TextField nameField;
    public TextField rentalRateField;
    public TableView<Category> categoriesTable;
    public TableColumn<Category, Integer> id;
    public TableColumn<Category, String> name;
    public TableColumn<Category, Double> rentalRate;
    public TableColumn<Category, Date> createdDate;
    public TableColumn<Category, Date> modifiedDate;

    public CategoriesController() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CategoriesService categoriesService = new CategoriesService();
        ArrayList<Category> categories = new ArrayList<>();

        try {
            categories = categoriesService.get("all");
            System.out.println(categories.isEmpty());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        categoryObservableList.addAll(categories);

        //make sure the property value factory should be exactly same as the e.g getId from your model class
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        rentalRate.setCellValueFactory(new PropertyValueFactory<>("rentalRate"));
        createdDate.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
        modifiedDate.setCellValueFactory(new PropertyValueFactory<>("modifiedDate"));
        categoriesTable.setItems(categoryObservableList);
    }

    private final ObservableList<Category> categoryObservableList = FXCollections.observableArrayList();

    public void onAddButtonClick() throws SQLException {
        String name = nameField.getText();
        double rentalRate = Double.parseDouble(rentalRateField.getText());

        // Add to db
        CategoriesService categoriesService = new CategoriesService();
        categoriesService.add(new Category(name, rentalRate));

        // Get last category from db and update TableView
        Category lastCategory = categoriesService.get("last").get(0);
        categoryObservableList.add(lastCategory);
    }
}
