package org.example.services.impl;

import org.example.domain.Reservation;
import org.example.domain.ReservationRequest;
import org.example.domain.VehiculeCategory;
import org.example.repositories.ReservationRepository;
import org.example.services.ReservationService;

public class ReservationServiceImpl implements ReservationService {

    private static int currentReference = 238394;
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation book(ReservationRequest request) {
        Reservation result = new Reservation(request, ReservationServiceImpl.currentReference);
        reservationRepository.add(result);
        ReservationServiceImpl.currentReference++;
        return result;
    }

    @Override
    public void cancel(int reference) {
        reservationRepository.delete(reference);
    }

    @Override
    public Iterable<Reservation> list(VehiculeCategory vehiculeCategory) {
        return reservationRepository.findByCategory(vehiculeCategory);
    }

    @Override
    public Reservation findByReference(int reference) {
        return reservationRepository.findByReference(reference);
    }

    @Override
    public Reservation changeReservationClient(Reservation a, String client) {
        a.setFullname(client);
        return reservationRepository.update(a);
    }

}
