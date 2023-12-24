package com.example.biblio.Service;

import com.example.biblio.Model.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservation();
    Reservation getOneReservationById( int id);

    Reservation updateReservation(Reservation reservation ,int id);

    void deleteReservation( int id);

    Reservation saveReservation(Reservation reservation);
}
