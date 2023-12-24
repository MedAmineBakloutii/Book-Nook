package com.example.biblio.Service;

import com.example.biblio.Model.Emprunts;

import java.util.List;

public interface EmpruntService {
    List<Emprunts> getAllEmprunt();
    Emprunts getOneEmpruntsById( int id);

    Emprunts updateEmprunts(Emprunts emprunts ,int id);

    void deleteEmprunts( int id);

    Emprunts saveEmprunts(Emprunts emprunts);
}
