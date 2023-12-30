package net.javaguides.bibliotheque.Service;



import net.javaguides.bibliotheque.Model.Emprunts;

import java.util.List;

public interface EmpruntService {
    List<Emprunts> getAllEmprunt();
    Emprunts getOneEmpruntsById(int id);

    Emprunts updateEmprunts(Emprunts emprunts, int id);

    void deleteEmprunts(int id);

    Emprunts saveEmprunts(Emprunts emprunts);
}
