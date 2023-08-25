package me.naffah.partyrentals.services;
import me.naffah.partyrentals.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> get(String fetchLocation) throws SQLException {
        ArrayList<Product> productArrayList = new ArrayList<>();

        Connection conn = new DBService().connect();
        PreparedStatement ps = null;

        switch (fetchLocation) {
            case "all" -> ps = conn.prepareStatement("SELECT * FROM products");
            case "last" -> ps = conn.prepareStatement("SELECT * FROM products ORDER BY id DESC LIMIT 1;");
            default -> {
            }
        }

        assert ps != null;
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product product = new Product();

            product.setId(rs.getInt(1));
            product.setName(rs.getString(2));
            product.setSku(rs.getString(3));
            product.setDescription(rs.getString(4));
            product.setPrice(rs.getDouble(5));
            product.setQty(rs.getInt(6));
            product.setCategoryId(rs.getInt(7));
            product.setCreatedDate(rs.getDate(8));
            product.setModifiedDate(rs.getDate(9));

            productArrayList.add(product);
        }
        conn.close();

        return productArrayList;
    }
}
