package com.example.biblio.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "Emprunts")

public class Emprunts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(nullable = false, name= "date_debut")
    private LocalDate date_debut;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(nullable = false, name= "date_fin")
    private LocalDate date_fin;
}
