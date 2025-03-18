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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionCommandes", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    // Consulter un article par sa référence
    public Articles consulterArticle(int refArticle) throws RemoteException {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Article WHERE Ref_Article = ?");
            stmt.setInt(1,refArticle);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Articles(
                        rs.getInt("Référence_Article"),
                        rs.getString("Libellé"),
                        rs.getDouble("Prix_Unitaire"),
                        rs.getInt("ID_Famille")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}