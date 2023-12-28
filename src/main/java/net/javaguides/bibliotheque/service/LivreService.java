package net.javaguides.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.bibliotheque.Model.Livre;
import net.javaguides.bibliotheque.Repository.LivreRepository;

import java.util.List;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;
    
    
    public Livre ajouterLivre(Livre livre) {
       return livreRepository.save(livre);
    }

    
    public Livre mettreAJourLivre(Long id, Livre livre) {
    	
        // Vérifiez si le livre existe
        if (livreRepository.existsById(id)) {
            livre.setId(id);
            return livreRepository.save(livre);
        }
        return null; // Livre non trouvé
    }
    
    public void supprimerLivre(Long id) {
        livreRepository.deleteById(id);
    }
    
    public Livre ajouterExemplaires(Long id, int quantite) {
        Livre livre = livreRepository.findById(id).orElse(null);
        if (livre != null) {
            livre.setNbExemplaires(livre.getNbExemplaires() + quantite);
            return livreRepository.save(livre);
        }
        return null; // Livre non trouvé
    }
    

//Catalogue en ligne
    
    public List<Livre> rechercherLivres(String titre, String auteur, String categorie) {
        return livreRepository.findByTitreContainingAndAuteurContainingAndCategorieContaining(
                titre, auteur, categorie);
    }
    
    
 //Affichage des disponibilités des livres dans le catalogue.
   
    public List<Livre> obtenirLivresDisponibles() {
        return livreRepository.findByDisponibilite(true);
    }
    
    
    
    

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Livre getLivreById(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    public void saveLivre(Livre livre) {
        livreRepository.save(livre);
    }

    
}