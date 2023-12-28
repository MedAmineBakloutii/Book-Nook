package net.javaguides.bibliotheque.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.bibliotheque.Repository.LivreRepository;

import java.util.List;

@Service
public class LivreService {
    @Autowired
    private LivreRepository livreRepository;
    
    


    public List<Livre> rechercherLivresAvecDisponibilite(String titre, String auteur, String categorie, boolean disponible) {
        return livreRepository.findByTitreContainingAndAuteurContainingAndCategorieContainingAndDisponibilite(
                titre, auteur, categorie, disponible);
    }
    
    public List<Livre> rechercherLivresParCategorie(String categorie) {
        return livreRepository.findByCategorie(categorie);
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

    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }
}