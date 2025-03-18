package modele;

public class Famille{
    private int idFamille;
    private String nomFamille;

    public Famille(int idFamille, String nomFamille) {
        this.idFamille = idFamille;
        this.nomFamille = nomFamille;
    }

    public int getIdFamille() { return idFamille; }
    public void setIdFamille(int idFamille) { this.idFamille = idFamille; }

    public String getNomFamille() { return nomFamille; }
    public void setNomFamille(String nomFamille) { this.nomFamille = nomFamille; }

    @Override
    public String toString() {
        return "Famille [id=" + idFamille + ", nom=" + nomFamille + "]";
    }
}
