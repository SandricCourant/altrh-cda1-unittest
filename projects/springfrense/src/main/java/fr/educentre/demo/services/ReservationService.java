package fr.educentre.demo.services;

import fr.educentre.demo.domain.Reservation;
import fr.educentre.demo.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private static int currentReference = 238394;

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation book(Reservation reservation) {
        reservation.setReference(++ReservationService.currentReference);
        reservationRepository.save(reservation);
        return reservation;
    }

    public void cancel(int reference) {
        reservationRepository.delete(findByReference(reference));
    }


    public Reservation findByReference(int reference) {
        return reservationRepository.findByReference(reference);
    }

    public Reservation changeReservationClient(Reservation reservation, String client) {
        reservation.setFullname(client);
        return reservationRepository.save(reservation);
    }

}
