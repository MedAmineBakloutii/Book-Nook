package net.javaguides.bibliotheque.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.bibliotheque.Model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {
	
	  List<Livre> findByTitreContainingAndAuteurContainingAndCategorieContaining(
	            String titre, String auteur, String categorie);
	  
	  List<Livre> findByDisponibilite(boolean disponibilite);
}

