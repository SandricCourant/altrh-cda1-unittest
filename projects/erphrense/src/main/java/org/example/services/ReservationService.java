package org.example.services;

import org.example.domain.Reservation;
import org.example.domain.ReservationRequest;
import org.example.domain.VehiculeCategory;

public interface ReservationService {

    Reservation book(ReservationRequest request);

    void cancel(int reference);

    Iterable<Reservation> list(VehiculeCategory vehiculeCategory);

    Reservation findByReference(int reference);

    Reservation changeReservationClient(Reservation a, String client);
    
}
