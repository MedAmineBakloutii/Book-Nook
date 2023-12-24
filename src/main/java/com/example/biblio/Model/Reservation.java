package com.example.biblio.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Reservation")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
