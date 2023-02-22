package org.example.repositories;

import org.example.domain.Reservation;
import org.example.domain.VehiculeCategory;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {

    private List<Reservation> reservations;

    public ReservationRepository() {
        reservations = new ArrayList<>();
    }

    public void add(Reservation reservation) {
        reservations.add(reservation);
    }

    public void delete(int reference) {
        for (Reservation r : reservations) {
            if (r.getReference() == reference) {
                reservations.remove(r);
                break;
            }
        }
    }

    public List<Reservation> findByCategory(VehiculeCategory vehiculeCategory) {
        List<Reservation> results = new ArrayList<>();

        for (Reservation r : reservations) {
            if (r.getVehiculeCategory().equals(vehiculeCategory)) {
                results.add(r);
            }
        }

        return results;
    }

    public Reservation findByReference(int reference) {
        for (Reservation r : reservations) {
            if (r.getReference() == reference) {
                return r;
            }
        }

        return null;
    }

    public Reservation update(Reservation reservation) {
        Reservation r = findByReference(reservation.getReference());

        r.setArrival(reservation.getArrival());
        r.setDeparture(reservation.getDeparture());
        r.setFullname(reservation.getFullname());
        r.setStartAt(reservation.getStartAt());
        r.setEndAt(reservation.getEndAt());
        r.setVehiculeCategory(reservation.getVehiculeCategory());
        r.setVehiculeSubCategory(reservation.getVehiculeSubCategory());

        return r;
    }

}
