package org.example.repositories;

import org.example.domain.VehiculeCategory;
import org.example.domain.VehiculeSubCategory;

import java.util.ArrayList;
import java.util.List;

public class VehiculeSubCategoryRepository {

    // Jet : Eco, Confort, Hypersonic
    // Voiture : Turbo, Circuit
    private List<VehiculeSubCategory> data;

    public VehiculeSubCategoryRepository() {
        this.data = new ArrayList<>();
        VehiculeCategory jet = new VehiculeCategory("Jet");
        data.add(new VehiculeSubCategory(jet, "Eco"));
        data.add(new VehiculeSubCategory(jet, "Confort"));
        data.add(new VehiculeSubCategory(jet, "Hypersonic"));

        VehiculeCategory voiture = new VehiculeCategory("Voiture");
        data.add(new VehiculeSubCategory(voiture, "Circuit"));
        data.add(new VehiculeSubCategory(voiture, "Turbo"));

        VehiculeCategory bateau = new VehiculeCategory("Bateau");
        data.add(new VehiculeSubCategory(bateau, "Peniche"));
        data.add(new VehiculeSubCategory(bateau, "Croisière"));
    }

    public List<VehiculeSubCategory> provide() {
        return data;
    }

    public List<VehiculeSubCategory> findBy(VehiculeCategory category) {
        List<VehiculeSubCategory> results = new ArrayList<>();

        for (VehiculeSubCategory s : data) {
            if (s.getCategory().equals(category)) {
                results.add(s);
            }
        }

        return results;
    }

    public VehiculeSubCategory find(VehiculeCategory category, int index) {
        return findBy(category).get(index);
    }

    public VehiculeSubCategory create(VehiculeCategory category, String name) {
        VehiculeSubCategory subCategory = new VehiculeSubCategory(category, name);
        data.add(subCategory);
        return subCategory;
    }
}

