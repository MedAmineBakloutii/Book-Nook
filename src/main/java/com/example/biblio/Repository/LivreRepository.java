package com.example.biblio.Repository;


import com.example.biblio.Model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {

	List<Livre> findByTitreContainingAndAuteurContainingAndCategorieContaining(
			String titre, String auteur, String categorie);

	List<Livre> findByTitreContainingAndAuteurContainingAndCategorieContainingAndDisponibilite(
			String titre, String auteur, String categorie, boolean disponible);



	List<Livre> findByDisponibilite(boolean disponibilite);


	List<Livre> findByCategorie(String categorie);










}

