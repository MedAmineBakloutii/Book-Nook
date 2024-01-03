package com.example.biblio.Controller;


import com.example.biblio.Model.Categorie;
import com.example.biblio.Service.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/categorie")
public class CategorieController {
    private CategorieService categorieService;

    public CategorieController(CategorieService categorieSerwvice) {
        super();
        this.categorieService = categorieService;
    }

    // build create categorie REST API
    @PostMapping()
    public ResponseEntity<Categorie> saveCategorie(@RequestBody Categorie
                                                           categorie) {
        return new
                ResponseEntity<Categorie>(categorieService.saveCategorie(categorie),
                HttpStatus.CREATED);
    }

    // build get all Categories REST API
    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    // build get categorie by id REST API
// http://localhost:8080/api/Categories/1
    @GetMapping("{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable("id")
                                                      long categorieId) {
        return new
                ResponseEntity<Categorie>(categorieService.getCategorieById(categorieId),
                HttpStatus.OK);
    }

    // build update categorie REST API
// http://localhost:8080/api/categorie/1
    @PutMapping("{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable("id")
                                                     long id
            , @RequestBody Categorie categorie) {
        return new
                ResponseEntity<Categorie>(categorieService.updateCategorie(categorie, id),
                HttpStatus.OK);
    }

    // build delete categorie REST API
// http://localhost:8080/api/categories/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategorie(@PathVariable("id") long id) {
// delete categorie from DB
        categorieService.deleteCategorie(id);
        return new ResponseEntity<String>("Categorie deleted successfully!.", HttpStatus.OK);

    }
}
