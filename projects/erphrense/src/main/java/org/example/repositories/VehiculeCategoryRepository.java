package org.example.repositories;

import org.example.domain.VehiculeCategory;

import java.util.ArrayList;
import java.util.List;

public class VehiculeCategoryRepository {

    private List<VehiculeCategory> data;

    public VehiculeCategoryRepository() {
        this.data = new ArrayList<>();
        data.add(new VehiculeCategory("Jet"));
        data.add(new VehiculeCategory("Voiture"));
        data.add(new VehiculeCategory("Bateau"));
    }

    public List<VehiculeCategory> provide() {
        return data;
    }

    public VehiculeCategory find(int index) {
        return data.get(index);
    }

    public VehiculeCategory create(String name) {
        VehiculeCategory category = new VehiculeCategory(name);
        data.add(category);
        return category;
    }

}

