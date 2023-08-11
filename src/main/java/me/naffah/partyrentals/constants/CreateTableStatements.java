package me.naffah.partyrentals.constants;

import java.util.HashMap;

public class CreateTableStatements {
    public static HashMap<String, String> statements = new HashMap<>() {{
        put("employees", "CREATE TABLE IF NOT EXISTS employees " +
                "(id INTEGER PRIMARY KEY NOT NULL, " +
                "fullName VARCHAR(70) NOT NULL, " +
                "username VARCHAR(30) UNIQUE NOT NULL, " +
                "address VARCHAR(255) NOT NULL, " +
                "phone VARCHAR(15) NOT NULL, " +
                "email VARCHAR(320) UNIQUE, " +
                "password VARCHAR(255) NOT NULL, " +
                "loginStatus BOOLEAN NOT NULL, " +
                "createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "modifiedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
    }};
}
