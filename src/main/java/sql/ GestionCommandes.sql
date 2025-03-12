CREATE DATABASE GestionCommandes;
USE GestionCommandes;

-- Table Famille
CREATE TABLE Famille (
                         Id_famille INT PRIMARY KEY AUTO_INCREMENT,
                         Nom_famille VARCHAR(255) NOT NULL
);

-- Table Article
CREATE TABLE Article (
                         Ref_article INT PRIMARY KEY AUTO_INCREMENT,
                         Libellé VARCHAR(255) NOT NULL,
                         Prix_unitaire DECIMAL(10,2) NOT NULL,
                         Quantité_Stock INT NOT NULL,
                         Id_famille INT NOT NULL,
                         FOREIGN KEY (Id_famille) REFERENCES Famille(Id_famille)
);

-- Table Commande
CREATE TABLE Commande (
                          Id_commande INT PRIMARY KEY AUTO_INCREMENT,
                          Date_commande DATE NOT NULL,
                          Mode_paiement VARCHAR(100) NOT NULL
);

-- Table Articles_Commandes (relation entre Article et Commande)
CREATE TABLE Articles_Commandes (
                                    Id_commande INT,
                                    Ref_article INT,
                                    Quantite INT NOT NULL,
                                    Prix_vente DECIMAL(10,4) NOT NULL,
                                    PRIMARY KEY (Id_commande, Ref_article),
                                    FOREIGN KEY (Id_commande) REFERENCES Commande(Id_commande),
                                    FOREIGN KEY (Ref_article) REFERENCES Article(Ref_article)
);
