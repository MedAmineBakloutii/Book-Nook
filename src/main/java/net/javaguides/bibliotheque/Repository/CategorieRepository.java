package net.javaguides.bibliotheque.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.bibliotheque.Model.Categorie;
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    List<Categorie> findByNom(String nom);
}
