package com.example.biblio.Service;


import com.example.biblio.Model.Livre;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LivreService {

    Livre ajouterLivre(Livre livre);

    Livre mettreAJourLivre(Long id, Livre livre);

    void supprimerLivre(Long id);

    Livre ajouterExemplaires(Long id, int quantite);

    List<Livre> rechercherLivres(String titre, String auteur, String categorie);

    List<Livre> rechercherLivresAvecDisponibilite(String titre, String auteur, String categorie, boolean disponible);


    List<Livre> rechercherLivresParCategorie(String categorie);

    List<Livre> obtenirLivresDisponibles();

    Livre getLivreById(Long id);


    List<Livre> getAlllivre();

    Livre getOneLivreById(int id);

}