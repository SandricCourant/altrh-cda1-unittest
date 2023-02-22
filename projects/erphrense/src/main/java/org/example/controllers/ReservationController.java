package org.example.controllers;

import org.example.domain.Reservation;
import org.example.domain.ReservationRequest;
import org.example.domain.VehiculeCategory;
import org.example.domain.VehiculeSubCategory;
import org.example.services.ReservationService;
import org.example.services.VehiculeService;

import java.util.ArrayList;
import java.util.List;

public class ReservationController {


    private final ReservationService reservationService;
    private final VehiculeService vehiculeService;

    public ReservationController(ReservationService reservationService,
                                 VehiculeService vehiculeService) {
        this.reservationService = reservationService;
        this.vehiculeService = vehiculeService;
    }

    public String book(int vehiculeCategoryIndex, int vehiculeSubCategoryIndex, String fullname, String departure, String arrival, String startAt, String endAt) {
        // On récupère la categorie et la sous-catégorie
        VehiculeCategory category = vehiculeService.findCategory(vehiculeCategoryIndex);
        VehiculeSubCategory subCategory = vehiculeService.findSubCateogry(category, vehiculeSubCategoryIndex);

        // On crée la demande de réservation
        ReservationRequest request = new ReservationRequest(category, subCategory, fullname, departure, arrival, startAt, endAt);

        // On réserve
        Reservation reservation = reservationService.book(request);

        return Integer.toString(reservation.getReference()) + " = " + reservation.getVehiculeCategory().toString() + ", " + reservation.getVehiculeSubCategory().toString();
    }

    public void cancel(int reference) {
        reservationService.cancel(reference);
    }

    public List<String> list(int vehiculeCategoryIndex) {
        List<String> results = new ArrayList<>();
        VehiculeCategory vehiculeCategory = vehiculeService.findCategory(vehiculeCategoryIndex);
        for (Reservation r : reservationService.list(vehiculeCategory)) {
            results.add(r.toString());
        }

        return results;
    }

    public String findByReference(int reference) {
        Reservation reservation = reservationService.findByReference(reference);
        if (reservation == null) {
            return "Non trouvée";
        }

        return "R" + reservation.getReference() + ", client: " +
                reservation.getFullname() + ", " + reservation.getVehiculeCategory().getName() +
                ", " + reservation.getVehiculeSubCategory().getName() +
                ", debut: " + reservation.getStartAt() +
                ", fin: " + reservation.getEndAt();
    }

    public boolean changeReservationClient(int reference, String client) {
        Reservation r = reservationService.findByReference(reference);
        if (r == null) {
            return false;
        }

        reservationService.changeReservationClient(r, client);
        return true;
    }
}
