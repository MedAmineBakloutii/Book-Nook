package com.example.biblio.impl;



import com.example.biblio.Model.Livre;
import com.example.biblio.Repository.LivreRepository;
import com.example.biblio.Service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LivreImplement implements LivreService {


    @Autowired
    private LivreRepository livreRepository;

    @Override
    public Livre ajouterLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Livre mettreAJourLivre(Long id, Livre livre) {

        // Vérifiez si le livre existe
        if (livreRepository.existsById(id)) {
            livre.setId(id);
            return livreRepository.save(livre);
        }
        return null; // Livre non trouvé
    }
    @Override
    public void supprimerLivre(Long id) {
        livreRepository.deleteById(id);
    }
    @Override
    public Livre ajouterExemplaires(Long id, int quantite) {
        Livre livre = livreRepository.findById(id).orElse(null);
        if (livre != null) {
            livre.setNbExemplaires(livre.getNbExemplaires() + quantite);
            return livreRepository.save(livre);
        }
        return null; // Livre non trouvé
    }

    //Catalogue en ligne
    @Override
    public List<Livre> rechercherLivres(String titre, String auteur, String categorie) {
        return livreRepository.findByTitreContainingAndAuteurContainingAndCategorieContaining(
                titre, auteur, categorie);
    }
    @Override
    public List<Livre> rechercherLivresAvecDisponibilite(String titre, String auteur, String categorie, boolean disponible) {
        return livreRepository.findByTitreContainingAndAuteurContainingAndCategorieContainingAndDisponibilite(
                titre, auteur, categorie, disponible);
    }


    @Override
    public List<Livre> rechercherLivresParCategorie(String categorie) {
        return livreRepository.findByCategorie(categorie);
    }

    //Affichage des disponibilités des livres dans le catalogue.
    @Override
    public List<Livre> obtenirLivresDisponibles() {
        return livreRepository.findByDisponibilite(true);
    }


    @Override
    public Livre getLivreById(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Livre> getAlllivre() {

        return this.livreRepository.findAll();
    }

    @Override
    public Livre getOneLivreById(int id) {

        return this.livreRepository.findById((long) id).orElse(null);
    }


}
