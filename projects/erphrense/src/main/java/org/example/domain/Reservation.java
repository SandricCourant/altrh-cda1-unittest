package org.example.domain;

public class Reservation extends ReservationRequest {

    private int reference;

    public Reservation(ReservationRequest request, int reference) {
        super(request.vehiculeCategory, request.vehiculeSubCategory, request.fullname, request.departure, request.arrival, request.startAt, request.endAt);
        this.reference = reference;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "R" + reference + ", client: " + fullname + ", " + vehiculeSubCategory.getName();
    }
}
