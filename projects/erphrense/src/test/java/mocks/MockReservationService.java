package mocks;

import org.example.domain.Reservation;
import org.example.domain.ReservationRequest;
import org.example.domain.VehiculeCategory;
import org.example.domain.VehiculeSubCategory;
import org.example.services.ReservationService;

import java.util.ArrayList;
import java.util.List;

public class MockReservationService implements ReservationService {

    @Override
    public Reservation book(ReservationRequest request) {
        return new Reservation(request, 99999);
    }

    @Override
    public void cancel(int reference) {
    }

    @Override
    public Iterable<Reservation> list(VehiculeCategory vehiculeCategory) {
        List<Reservation> results = new ArrayList<>();
        VehiculeCategory category = new VehiculeCategory("Jet");
        VehiculeSubCategory subCategory = new VehiculeSubCategory(category, "Eco");
        ReservationRequest request = new ReservationRequest(category, subCategory, "Annie Versaire", "Paris", "New York", "2023-01-23", "2023-02-15");
        results.add(new Reservation(request, 9999));
        return results;
    }

    @Override
    public Reservation findByReference(int reference) {
        // TODO: A remplir
        return null;
    }

    @Override
    public Reservation changeReservationClient(Reservation a, String client) {
        // TODO: A remplir
        return null;
    }
}
