package net.javaguides.bibliotheque.Repository;


import net.javaguides.bibliotheque.Model.Emprunts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<Emprunts, Integer > {


}
