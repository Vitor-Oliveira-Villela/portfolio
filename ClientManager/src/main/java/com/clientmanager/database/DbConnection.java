package com.clientmanager.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/ClientManagerDB";
        String user = "postgres";
        String password = "136300";

        return DriverManager.getConnection(url, user, password);
    }
}