package me.naffah.partyrentals.services;

import me.naffah.partyrentals.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriesService {

    public void add(Category category) throws SQLException {
        Connection conn = new DBService().connect();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO categories (name, rentalRate) VALUES (?, ?)");
        ps.setString(1, category.getName());
        ps.setDouble(2, category.getRentalRate());
        ps.execute();
        conn.close();
    }

    public ArrayList<Category> get() throws SQLException {
        ArrayList<Category> categoryArrayList = new ArrayList<>();

        Connection conn = new DBService().connect();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM categories");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Category category = new Category();

            category.setId(rs.getInt(1));
            category.setName(rs.getString(2));
            category.setRentalRate(rs.getDouble(3));
            category.setCreatedDate(rs.getDate(4));
            category.setModifiedDate(rs.getDate(5));

            categoryArrayList.add(category);
        }
        conn.close();

        return categoryArrayList;
    }
}
