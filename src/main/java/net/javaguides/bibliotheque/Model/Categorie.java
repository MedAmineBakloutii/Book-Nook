package net.javaguides.bibliotheque.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String Nom;

    @OneToMany(mappedBy = "livre", cascade = CascadeType.ALL)

    private List<Livre> livre;

}