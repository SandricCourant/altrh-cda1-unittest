package fr.educentre.demo.controllers;

import fr.educentre.demo.domain.Reservation;
import fr.educentre.demo.domain.VehiculeSubCategory;
import fr.educentre.demo.dto.RenameReservationClientRequestDto;
import fr.educentre.demo.dto.ReservationRequestDto;
import fr.educentre.demo.exceptions.ReservationNotFoundException;
import fr.educentre.demo.services.ReservationService;
import fr.educentre.demo.services.VehiculeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping("/sub-categories/{id}/reservations")
    public ResponseEntity<Reservation> book(@PathVariable int id, @Valid @RequestBody ReservationRequestDto dto) throws URISyntaxException {

        // Factoring reservation
        Reservation reservation = new Reservation();
        reservation.setArrival(dto.getArrival());
        reservation.setDeparture(dto.getDeparture());
        reservation.setFullname(dto.getEmail());
        reservation.setEndAt(dto.getEndAt());
        reservation.setStartAt(dto.getStartAt());
        VehiculeSubCategory subCategory = vehiculeService.findSubCategoryById(id);
        reservation.setSubCategory(subCategory);

        // Booking
        reservation = reservationService.book(reservation);

        String reservationURI = "/reservations/" + reservation.getReference();
        return ResponseEntity.created(new URI(reservationURI)).body(reservation);  // Sending a 201 HTTP status code
    }

    @DeleteMapping("/reservations/{reference}")
    public ResponseEntity<?> cancel(@PathVariable int reference) {
        reservationService.cancel(reference);
        return ResponseEntity.noContent().build(); // Sending a 204 HTTP status code
    }

    @GetMapping("/sub-categories/{id}/reservations")
    public ResponseEntity<Iterable<Reservation>> findBySubCategory(@PathVariable int id) {
        VehiculeSubCategory subCategory = vehiculeService.findSubCategoryById(id);
        return ResponseEntity.ok(subCategory.getReservations()); // Sending a 200 HTTP status code
    }

    @GetMapping("/reservations/{reference}")
    public ResponseEntity<Reservation> findByReference(@PathVariable int reference) throws ReservationNotFoundException {
        Reservation reservation = reservationService.findByReference(reference);
        if (reservation == null) {
            throw new ReservationNotFoundException();
        }
        return ResponseEntity.ok(reservation); // Sending a 200 HTTP status code
    }

    @PutMapping("/reservations/{reference}")
    public ResponseEntity<Reservation> changeReservationClient(@PathVariable int reference, @Valid @RequestBody RenameReservationClientRequestDto dto) throws ReservationNotFoundException {
        Reservation reservation = reservationService.findByReference(reference);
        if (reservation == null) {
            throw new ReservationNotFoundException();
        }

        reservation = reservationService.changeReservationClient(reservation, dto.getNewEmail());
        return ResponseEntity.ok(reservation); // Sending a 200 HTTP status code
    }
}
