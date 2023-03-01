package fr.educentre.demo.services.impl;

import fr.educentre.demo.domain.Reservation;
import fr.educentre.demo.repositories.ReservationRepository;
import fr.educentre.demo.services.ReferenceService;
import fr.educentre.demo.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReferenceService referenceService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation book(Reservation reservation) {
        reservation.setReference(referenceService.getNewReference());
        reservationRepository.save(reservation);
        return reservation;
    }

    @Override
    public void cancel(int reference) {
        reservationRepository.delete(findByReference(reference));
    }

    @Override
    public Reservation findByReference(int reference) {
        return reservationRepository.findByReference(reference);
    }

    @Override
    public Reservation changeReservationClient(Reservation reservation, String client) {
        reservation.setFullname(client);
        return reservationRepository.save(reservation);
    }

}
