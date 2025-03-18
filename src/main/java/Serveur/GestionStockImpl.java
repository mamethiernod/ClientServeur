package Serveur;

import interfaces.IGestionStock;
import modele.Articles;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;

public class GestionStockImpl extends UnicastRemoteObject implements IGestionStock {
    private Connection connection;

    public GestionStockImpl() throws RemoteException {
        super();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionCommandes", "root", "root");
            if (connection == null) {
                throw new SQLException("La connexion à la base de données a échoué.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Erreur lors de la connexion à la base de données.", e);
        }
    }

    @Override
    // Consulter un article par sa référence
    public Articles consulterArticle(int refArticle) throws RemoteException {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Article WHERE Ref_Article = ?;");
            stmt.setInt(1, refArticle);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Articles(
                        rs.getInt("Ref_Article"),
                        rs.getString("Libellé"),
                        rs.getDouble("Prix_Unitaire"),
                        rs.getInt("ID_Famille")
                );
            } else {
                // Aucun article trouvé avec cette référence
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Erreur lors de l'exécution de la requête SQL.", e);
        }
    }


}