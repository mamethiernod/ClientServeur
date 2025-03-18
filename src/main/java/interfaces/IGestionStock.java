package interfaces;

import modele.Articles;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IGestionStock extends Remote {

    //  Consulter un article par sa référence
  Articles consulterArticle(int refArticle) throws RemoteException;
}

