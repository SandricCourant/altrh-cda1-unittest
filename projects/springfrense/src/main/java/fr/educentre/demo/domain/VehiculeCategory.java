package fr.educentre.demo.domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class VehiculeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "category")
    private Collection<VehiculeSubCategory> subCategories;

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

    public Collection<VehiculeSubCategory> getSubCategories() {
        return subCategories;
    }

}
