package net.javaguides.bibliotheque.Model;

import net.javaguides.bibliotheque.Model.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie saveCategorie(Categorie categorie);
    List<Categorie> getAllCategories();
    Categorie getCategorieById(long id);
    Categorie updateCategorie(Categorie categorie, long id);
    void deleteCategorie(long id);
}
