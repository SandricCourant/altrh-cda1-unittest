package fr.educentre.demo.services;

import fr.educentre.demo.domain.Reservation;
import fr.educentre.demo.domain.VehiculeCategory;

public interface ReservationService {

    Reservation book(Reservation request);

    void cancel(int reference);

    Reservation findByReference(int reference);

    Reservation changeReservationClient(Reservation a, String client);
    
}
