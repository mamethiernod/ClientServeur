USE GestionCommandes;
-- Insértion des familles (marques)
INSERT INTO Famille (Nom_famille) VALUES 
('Nike'),
('Adidas'),
('Puma'),
('Reebok'),
('New Balance');

-- Insértion des articles (produits de sport)
INSERT INTO Article (Libellé, Prix_unitaire, Quantité_Stock, Id_famille) VALUES 
('Chaussures de course Nike Air Zoom', 120.99, 50, 1),
('Maillot de football Adidas', 79.99, 30, 2),
('Ballon de basket Puma', 35.50, 100, 3),
('Haltères 10kg Reebok', 45.00, 25, 4),
('Short de sport New Balance', 29.99, 60, 5);

-- Insértion des commandes
INSERT INTO Commande (Date_commande, Mode_paiement) VALUES 
('2025-03-10', 'Carte bancaire'),
('2025-03-12', 'PayPal'),
('2025-03-15', 'Espèces');

-- Associer des articles aux commandes
INSERT INTO Articles_Commandes (Id_commande, Ref_article, Quantite, Prix_vente) VALUES 
(1, 1, 2, 120.99),
(1, 3, 1, 35.50),
(2, 2, 1, 79.99),
(2, 5, 3, 29.99),
(3, 4, 2, 45.00);
