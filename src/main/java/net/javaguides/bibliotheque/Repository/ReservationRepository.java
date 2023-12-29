package net.javaguides.bibliotheque.Repository;



import net.javaguides.bibliotheque.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer > {




}
