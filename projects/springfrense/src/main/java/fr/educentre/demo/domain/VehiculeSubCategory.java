package fr.educentre.demo.domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class VehiculeSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private VehiculeCategory category;

    @OneToMany(mappedBy = "subCategory")
    private Collection<Reservation> reservations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehiculeCategory getCategory() {
        return category;
    }

    public void setCategory(VehiculeCategory category) {
        this.category = category;
    }

    public Iterable<Reservation> getReservations() {
        return reservations;
    }
}
