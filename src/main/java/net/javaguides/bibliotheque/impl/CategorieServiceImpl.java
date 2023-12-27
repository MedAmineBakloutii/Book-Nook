package net.javaguides.bibliotheque.impl;

import java.util.List;
import java.util.Optional;

import net.javaguides.bibliotheque.Model.Categorie;
import net.javaguides.bibliotheque.Repository.CategorieRepository;
import net.javaguides.bibliotheque.exception.ResourceNotFoundException;
import net.javaguides.bibliotheque.Service.CategorieService;
import org.springframework.stereotype.Service;



@Service
public class CategorieServiceImpl implements CategorieService{
    private CategorieRepository categorieRepository;
    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        super();
        this.categorieRepository = categorieRepository;
    }
    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }
    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }
    @Override
    public Categorie getCategorieById(long id) {

        return categorieRepository.findById(id).orElseThrow(() ->
                new
                        ResourceNotFoundException("Categorie", "Id", id));
    }
    @Override
    public Categorie updateCategorie(Categorie categorie, long id) {
// we need to check whether categorie with given id is exist in DB or not
        Categorie existingCategorie =
                categorieRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Categorie",
                                "Id", id));
        existingCategorie.setNom(categorie.getNom());

// save existing categorie to DB
        categorieRepository.save(existingCategorie);
        return existingCategorie;
    }
    @Override
    public void deleteCategorie(long id) {
// check whether a categorie exist in a DB or not
        categorieRepository.findById(id).orElseThrow(() ->
                new
                        ResourceNotFoundException("Categorie", "Id", id));
        categorieRepository.deleteById(id);
    }
}
