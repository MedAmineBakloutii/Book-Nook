package net.javaguides.bibliotheque.impl;


import net.javaguides.bibliotheque.Model.Emprunts;
import net.javaguides.bibliotheque.Repository.EmpruntRepository;
import net.javaguides.bibliotheque.Service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmpruntImplement implements EmpruntService {

    @Autowired
    private EmpruntRepository emprunts;

    @Override
    public List<Emprunts> getAllEmprunt() {
        return this.emprunts.findAll();
    }

    @Override
    public Emprunts getOneEmpruntsById(int id) {
        return this.emprunts.findById( id).orElse(null);
    }

    @Override
    public Emprunts updateEmprunts(Emprunts emp, int id) {
        Optional<Emprunts> existEmprunts = this.emprunts.findById(id);
        if (existEmprunts.isPresent()) {
            Emprunts emprunts1 = existEmprunts.get();
            emprunts1.setDate_debut(emp.getDate_debut());
            emprunts1.setDate_fin(emp.getDate_fin());
            return emprunts.save(emprunts1);

        }else {
            return null;
        }

    }

    @Override
    public void deleteEmprunts(int id) {
        this.emprunts.deleteById(id);

    }

    @Override
    public Emprunts saveEmprunts(Emprunts emprunts) {
        return this.emprunts.save(emprunts);
    }
}
