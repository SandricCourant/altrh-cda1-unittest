package org.example.controllers;

import mocks.MockReservationService;
import org.example.domain.ReservationRequest;
import org.example.domain.VehiculeCategory;
import org.example.domain.VehiculeSubCategory;
import org.example.services.ReservationService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReservationControllerTest {

    private static ReservationController reservationController;

    @BeforeClass
    public static void setUpClass() {
        ReservationService reservationService = new MockReservationService();
        // TODO: A modifier pour le second argument
        reservationController = new ReservationController(reservationService, null);
    }

    @Test
    public void testBook() {
        VehiculeCategory category = new VehiculeCategory("Jet");
        VehiculeSubCategory subCategory = new VehiculeSubCategory(category, "Eco");
        ReservationRequest request = new ReservationRequest(category, subCategory, "Annie Versaire", "Paris", "New York", "2023-01-23", "2023-02-15");
        String result = reservationController.book(0, 0, "Annie Versaire", "Paris", "New York", "2023-01-23", "2023-02-15");
        Assert.assertEquals("99999 = Jet, Eco", result);
    }

}
