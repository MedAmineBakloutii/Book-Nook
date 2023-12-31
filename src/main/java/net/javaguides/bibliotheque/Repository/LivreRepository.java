package net.javaguides.bibliotheque.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.bibliotheque.Model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {
	
	List<Livre> findByTitreContainingAndAuteurContainingAndCategorieContaining(
            String titre, String auteur, String categorie);
	
	  List<Livre> findByTitreContainingAndAuteurContainingAndCategorieContainingAndDisponibilite(
	            String titre, String auteur, String categorie, boolean disponible);
	  
	 

	  List<Livre> findByDisponibilite(boolean disponibilite);
	  
	  
	  List<Livre> findByCategorie(String categorie);



	
	
	  
	  
	  
	  
	
}

