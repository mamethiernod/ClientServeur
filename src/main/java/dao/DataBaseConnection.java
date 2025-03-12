package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jdbc:mysql://localhost:8001" +
            "/GestionCommandes";
    private static final String USER = "root";  // Remplace par ton utilisateur MySQL
    private static final String PASSWORD = "";  // Mets ton mot de passe MySQL

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (con != null) {
                System.out.println(" Connexion réussie à la base de données !");
            }
        } catch (SQLException e) {
            System.err.println(" Erreur de connexion : " + e.getMessage());
        } finally {
            //  Nettoyage correct des connexions pour éviter le warning
            try {
                com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.uncheckedShutdown();
                System.out.println(" Nettoyage des connexions MySQL réussi.");
            } catch (Exception e) {
                System.err.println("Erreur lors du nettoyage des connexions : " + e.getMessage());
            }
        }
    }
}
