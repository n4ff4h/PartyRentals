package me.naffah.partyrentals.controllers.dashboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import me.naffah.partyrentals.models.Product;
import me.naffah.partyrentals.services.ProductService;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RentalController implements Initializable {
    public DatePicker startDateField;
    public DatePicker endDateField;
    public TableView<Product> productsTable;
    public TableColumn<Product, Integer> idCol;
    public TableColumn<Product, String> nameCol;
    public TableColumn<Product, String> skuCol;
    public TableColumn<Product, Integer> qtyCol;
    public TableColumn<Product, Double> priceCol;
    public TableColumn<Product, Integer> categoryCol;
    public Button addToCartButton;
    public TextField itemAmountButton;
    public TextField customerIdField;
    public ListView<String> saleOverviewListView;
    public TextField paidAmountField;
    public ComboBox<String> paymentMethodComboBox;
    public Button makeSaleButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startDateField.setValue(LocalDate.now());
        endDateField.setValue(LocalDate.now());
        ProductService productService = new ProductService();

        try {
            ArrayList<Product> products = productService.get("all");
            productObservableList.addAll(products);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //make sure the property value factory should be exactly same as the e.g getId from your model class
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        skuCol.setCellValueFactory(new PropertyValueFactory<>("sku"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        productsTable.setItems(productObservableList);

        productsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedProduct = newSelection;  // Save selected product to variable
        });

        paymentMethodComboBox.setItems(FXCollections.observableArrayList(
                "Cash",
                "Card",
                "Transfer"
        ));
    }

    private Product selectedProduct = null;
    // This holds the table data
    private final ObservableList<Product> productObservableList = FXCollections.observableArrayList();

    public void onAddtoCartButtonClick() {
        Product product = selectedProduct;
        saleOverviewListView.setItems(FXCollections.observableArrayList("hello", "hello2"));
    }
}
