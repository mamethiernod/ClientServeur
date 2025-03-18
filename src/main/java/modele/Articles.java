package modele;
import java.io.Serializable;

public class Articles implements Serializable{
    private int refArticle;
    private String libelle;
    private double prixUnitaire;
    private int quantiteStock;
    private int idFamille; // Référence vers la famille d'article

    public Articles(int refArticle, String libelle, double prixUnitaire, int quantiteStock, int idFamille) {
        this.refArticle = refArticle;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.quantiteStock = quantiteStock;
        this.idFamille = idFamille;
    }
    public Articles(int refArticle, String libelle, double prixUnitaire, int quantiteStock) {
        this.refArticle = refArticle;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.quantiteStock = quantiteStock;
        this.idFamille = idFamille;
    }

    public int getRefArticle() { return refArticle; }
    public void setRefArticle(int refArticle) { this.refArticle = refArticle; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }

    public int getQuantiteStock() { return quantiteStock; }
    public void setQuantiteStock(int quantiteStock) { this.quantiteStock = quantiteStock; }

    public int getIdFamille() { return idFamille; }
    public void setIdFamille(int idFamille) { this.idFamille = idFamille; }

    @Override
    public String toString() {
        return "Article [Ref=" + refArticle + ", Nom=" + libelle + ", Prix=" + prixUnitaire +
                ", Stock=" + quantiteStock + ", Famille=" + idFamille + "]";
    }
}
