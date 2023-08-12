package me.naffah.partyrentals.constants;

import java.util.HashMap;

//                "(id INTEGER PRIMARY KEY NOT NULL, " +
//                "createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
//                "modifiedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

public class CreateTableStatements {
    public static HashMap<String, String> statements = new HashMap<>() {{
        put("users", "CREATE TABLE IF NOT EXISTS users " +
                "(id INTEGER PRIMARY KEY NOT NULL, " +
                "fullName VARCHAR(50) NOT NULL, " +
                "username VARCHAR(30) UNIQUE NOT NULL, " +
                "phone VARCHAR(15), " +
                "email VARCHAR(320) UNIQUE, " +
                "password VARCHAR(255) NOT NULL, " +
                "createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "modifiedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

        put("categories", "CREATE TABLE IF NOT EXISTS categories " +
                "(id INTEGER PRIMARY KEY NOT NULL, " +
                "name VARCHAR(50) NOT NULL, " +
                "rentalRate REAL NOT NULL, " +
                "createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "modifiedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

        put("products", "CREATE TABLE IF NOT EXISTS products " +
                "(id INTEGER PRIMARY KEY NOT NULL, " +
                "name VARCHAR(70) NOT NULL, " +
                "description TEXT, " +
                "price REAL NOT NULL, " +
                "createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "modifiedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
    }};
}
