package net.javaguides.bibliotheque.Service;


import net.javaguides.bibliotheque.Model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservation();
    Reservation getOneReservationById(int id);

    Reservation updateReservation(Reservation reservation, int id);

    void deleteReservation(int id);

    Reservation saveReservation(Reservation reservation);
}
