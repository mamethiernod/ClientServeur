package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306" +
            "/gestioncommandes";
    private static final String USER = "root";  // Remplace par ton utilisateur MySQL
    private static final String PASSWORD = "root";  // Mets ton mot de passe MySQL

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (con != null) {
                System.out.println(" Connexion réussie à la base de données !");
            }
        } catch (SQLException e) {
            System.err.println(" Erreur de connexion : " + e.getMessage());
        }
    }
}
