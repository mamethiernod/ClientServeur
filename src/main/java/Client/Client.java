package Client;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import interfaces.IGestionStock;
import modele.Articles;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IGestionStock stockService = (IGestionStock) registry.lookup("StockService");

            Articles article = stockService.consulterArticle(1);
            if (article != null) {
                System.out.println("Article trouvé : " + article.getLibelle());
            } else {
                System.out.println("Article introuvable !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
