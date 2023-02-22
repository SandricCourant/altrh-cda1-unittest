package org.example.domain;

public class ReservationRequest {

    protected VehiculeCategory vehiculeCategory;
    protected VehiculeSubCategory vehiculeSubCategory;
    protected String fullname;
    protected String departure;
    protected String arrival;
    protected String startAt;
    protected String endAt;

    public ReservationRequest(VehiculeCategory vehiculeCategory, VehiculeSubCategory vehiculeSubCategory, String fullname, String departure, String arrival, String startAt, String endAt) {
        this.vehiculeCategory = vehiculeCategory;
        this.vehiculeSubCategory = vehiculeSubCategory;
        this.fullname = fullname;
        this.departure = departure;
        this.arrival = arrival;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }
    public VehiculeCategory getVehiculeCategory() {
        return vehiculeCategory;
    }

    public void setVehiculeCategory(VehiculeCategory vehiculeCategory) {
        this.vehiculeCategory = vehiculeCategory;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public VehiculeSubCategory getVehiculeSubCategory() {
        return vehiculeSubCategory;
    }

    public void setVehiculeSubCategory(VehiculeSubCategory vehiculeSubCategory) {
        this.vehiculeSubCategory = vehiculeSubCategory;
    }
}

