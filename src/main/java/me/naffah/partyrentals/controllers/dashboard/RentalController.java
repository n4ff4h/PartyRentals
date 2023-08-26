package me.naffah.partyrentals.controllers.dashboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import me.naffah.partyrentals.models.Customer;
import me.naffah.partyrentals.models.Product;
import me.naffah.partyrentals.services.CustomersService;
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
    public TextField paidAmountField;
    public ComboBox<String> paymentMethodComboBox;
    public Button makeSaleButton;
    public ComboBox<Customer> customerCombobox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startDateField.setValue(LocalDate.now());
        endDateField.setValue(LocalDate.now());
        ProductService productService = new ProductService();
        CustomersService customersService = new CustomersService();

        try {
            ArrayList<Product> products = productService.get("all");
            productObservableList.addAll(products);

            ArrayList<Customer> customers = customersService.get("all");
            customerObservableList.addAll(customers);
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

        // populate customers combobox
        Callback<ListView<Customer>, ListCell<Customer>> cellFactory = lv -> new ListCell<Customer>() {
            @Override
            protected void updateItem(Customer item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getFullName());
            }
        };
        customerCombobox.setButtonCell(cellFactory.call(null));
        customerCombobox.setCellFactory(cellFactory);
        customerCombobox.setItems(customerObservableList);

        paymentMethodComboBox.setItems(FXCollections.observableArrayList(
                "Cash",
                "Card",
                "Transfer"
        ));
    }

    private Product selectedProduct = null;
    // This holds the table data
    private final ObservableList<Product> productObservableList = FXCollections.observableArrayList();
    private final ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

    public void onAddtoCartButtonClick() {
        Customer customer = customerCombobox.getValue();
        if (customer != null) {

        } else {
            // TODO: Display error
        }
    }
}
