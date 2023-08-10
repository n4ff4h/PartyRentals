module me.naffah.partyrentals {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens me.naffah.partyrentals to javafx.fxml;
    exports me.naffah.partyrentals;
    exports me.naffah.partyrentals.controllers;
    opens me.naffah.partyrentals.controllers to javafx.fxml;
}