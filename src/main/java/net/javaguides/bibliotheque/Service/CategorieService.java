package net.javaguides.bibliotheque.Service;

import java.util.List;
import net.javaguides.bibliotheque.Model.Categorie;
public interface CategorieService {
    Categorie saveCategorie(Categorie categorie);
    List<Categorie> getAllCategories();
    Categorie getCategorieById(long id);
    Categorie updateCategorie(Categorie categorie, long id);
    void deleteCategorie(long id);
}
