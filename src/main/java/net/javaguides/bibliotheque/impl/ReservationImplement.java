package net.javaguides.bibliotheque.impl;


import net.javaguides.bibliotheque.Model.Reservation;
import net.javaguides.bibliotheque.Repository.ReservationRepository;
import net.javaguides.bibliotheque.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationImplement implements ReservationService {

    @Autowired
    private ReservationRepository reservation;

    @Override
    public List<Reservation> getAllReservation() {

        return this.reservation.findAll();
    }

    @Override
    public Reservation getOneReservationById(int id) {

        return this.reservation.findById(id).orElse(null);
    }

    @Override
    public Reservation updateReservation(Reservation res, int id) {
        Optional<Reservation> existReservation = this.reservation.findById( id);

        return res;
    }

    @Override
    public void deleteReservation(int id) {
        this.reservation.deleteById(id);

    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return this.reservation.save(reservation);
    }

}
