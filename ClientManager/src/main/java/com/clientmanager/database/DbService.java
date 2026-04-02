package com.clientmanager.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.clientmanager.model.Client;

public class DbService {

    // Função para validar login do usuario e abrir sistemas de acordo com a 'Role' do usuario.
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
            e.printStackTrace();
            return found;
        }
    }

    // Função para listar todos os clientes cadastrados no sistemas.
    public static List<Client> clientList() {
        String sql = "SELECT * FROM clients";

        List<Client> clients = new ArrayList<>();

        try (Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Client c = new Client();

                    c.id            = rs.getInt("id");
                    c.name          = rs.getString("name");
                    c.email         = rs.getString("email");
                    c.phone         = rs.getString("phone");
                    c.birth_date    = rs.getDate("birth_date").toLocalDate();
                    c.gender        = rs.getString("gender");

                    clients.add(c);
                }
            }
            return clients;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Função para cadastrar um novo cliente no sistema.
    public static boolean addClient(String name, String email, String phone, LocalDate birth_date, String gender) {
        String sql = "INSERT INTO clients (name, email, phone, birth_date, gender) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setDate(4, java.sql.Date.valueOf(birth_date));
            stmt.setString(5, gender);

            stmt.executeUpdate();

            return true; 

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
