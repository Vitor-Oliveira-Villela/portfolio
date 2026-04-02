package com.clientmanager.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbService {

    public static boolean loginValidation(String username, String password) {
        String sql = "SELECT username, password FROM users WHERE username = ? and password = ?";

        boolean found = false;

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    found = true;
                }
            }
            return found;

        } catch (SQLException e) {
            System.out.println("Erro ao executar SELECT:");
            e.printStackTrace();
            return found;
        }
    }
}