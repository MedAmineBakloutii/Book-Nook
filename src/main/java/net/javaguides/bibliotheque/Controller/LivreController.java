package net.javaguides.bibliotheque.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.javaguides.bibliotheque.Model.Livre;
import net.javaguides.bibliotheque.Service.LivreService;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {
    @Autowired
    private LivreService livreService;

    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }
    @PostMapping
    public void saveLivre(@RequestBody Livre livre) {
        livreService.saveLivre(livre);
    }

    @PutMapping("/{id}")
    public void updateLivre(@PathVariable Long id, @RequestBody Livre livreMisAJour) {
        Livre livreExistant = livreService.getLivreById(id);
        if (livreExistant != null) {
            livreExistant.setTitre(livreMisAJour.getTitre());
            livreExistant.setAuteur(livreMisAJour.getAuteur());
            livreExistant.setDatePublication(livreMisAJour.getDatePublication());
            livreExistant.setIsbn(livreMisAJour.getIsbn());
            livreService.saveLivre(livreExistant);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreService.deleteLivre(id);
    }
    
    
    @GetMapping("/rechercherDisponibles")
    public List<Livre> rechercherLivresDisponibles(
            @RequestParam(required = false) String titre,
            @RequestParam(required = false) String auteur,
            @RequestParam(required = false) String categorie,
            @RequestParam(required = false) boolean disponible) {
        return livreService.rechercherLivresAvecDisponibilite(titre, auteur, categorie, disponible);
    }
    
    @GetMapping("/rechercherParCategorie")
    public List<Livre> rechercherLivresParCategorie(@RequestParam String categorie) {
        return livreService.rechercherLivresParCategorie(categorie);
    }
}


