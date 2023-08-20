package me.naffah.partyrentals.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriesService {

    public void add(String name, double rentalRate) throws SQLException {
        Connection conn = new DBService().connect();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO categories (name, rentalRate) VALUES (?, ?)");
        ps.setString(1, name);
        ps.setDouble(2, rentalRate);
        ps.execute();
        conn.close();
    }
}
