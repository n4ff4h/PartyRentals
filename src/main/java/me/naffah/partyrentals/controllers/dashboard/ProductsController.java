package me.naffah.partyrentals.controllers.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import me.naffah.partyrentals.models.Product;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {
    public TextField nameField;
    public TextField priceField;
    public TextField skuField;
    public TextField qtyField;
    public ComboBox<String> categoryCombobox;
    public TextArea descriptionArea;
    public TableView<Product> productsTable;
    public TableColumn<Product, Integer> idCol;
    public TableColumn<Product, String> nameCol;
    public TableColumn<Product, String> skuCol;
    public TableColumn<Product, Integer> qtyCol;
    public TableColumn<Product, Double> priceCol;
    public TableColumn<Product, Integer> categoryCol;
    public TableColumn<Product, Date> createdDateCol;
    public TableColumn<Product, Date> modifiedDateCol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onAddButtonClick(ActionEvent event) {
    }

    public void onUpdateButtonClick(ActionEvent event) {
    }

    public void onDeleteButtonClick(ActionEvent event) {
    }
}
