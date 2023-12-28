package net.javaguides.bibliotheque.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import net.javaguides.bibliotheque.Model.Livre;
import net.javaguides.bibliotheque.service.LivreService;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreController {
    @Autowired
    private LivreService livreService;
    
    
    @PostMapping("/ajouter")
    public Livre ajouterLivre(@RequestBody Livre livre) {
        return livreService.ajouterLivre(livre);
    }
    
    
    @PutMapping("/modifier/{id}")
    public Livre modifierLivre(@PathVariable Long id, @RequestBody Livre livre) {
        return livreService.mettreAJourLivre(id, livre);
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    public void supprimerLivre(@PathVariable Long id) {
        livreService.supprimerLivre(id);
    }
    
    @PostMapping("/{id}/ajouter-exemplaires/{quantite}")
    public Livre ajouterExemplaires(@PathVariable Long id, @PathVariable int quantite) {
        return livreService.ajouterExemplaires(id, quantite);
    }
    
    
    //Catalogue en ligne 
    @GetMapping("/rechercher")
    public List<Livre> rechercherLivres(
            @RequestParam(required = false) String titre,
            @RequestParam(required = false) String auteur,
            @RequestParam(required = false) String categorie){
        return livreService.rechercherLivres(titre, auteur, categorie);
    }
    
    

    //Affichage des disponibilités des livres dans le catalogue.
    @GetMapping("/disponibles")
    public List<Livre> obtenirLivresDisponibles() {
        return livreService.obtenirLivresDisponibles();
    }
    

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


  
    
   
    
    
    
}


