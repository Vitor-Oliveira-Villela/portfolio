package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/ClientManagerDB";
        String user = "postgres";
        String password = "136300";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
        }
    }
}