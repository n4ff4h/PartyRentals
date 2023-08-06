module me.naffah.partyrentals {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.naffah.partyrentals to javafx.fxml;
    exports me.naffah.partyrentals;
}