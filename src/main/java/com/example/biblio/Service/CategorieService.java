package com.example.biblio.Service;
import com.example.biblio.Model.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategorieService {
    Categorie saveCategorie(Categorie categorie);
    List<Categorie> getAllCategories();
    Categorie getCategorieById(long id);
    Categorie updateCategorie(Categorie categorie, long id);
    void deleteCategorie(long id);
}
