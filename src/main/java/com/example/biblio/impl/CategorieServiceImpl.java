package com.example.biblio.impl;


import com.example.biblio.Model.Categorie;
import com.example.biblio.Repository.CategorieRepository;
import com.example.biblio.Service.CategorieService;
import com.example.biblio.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
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
