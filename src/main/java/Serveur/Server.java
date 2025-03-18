package Serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            GestionStockImpl stock = new GestionStockImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("GestionStock", stock);
            System.out.println("Serveur RMI démarré...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
