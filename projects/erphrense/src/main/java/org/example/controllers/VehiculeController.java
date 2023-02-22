package org.example.controllers;

import org.example.domain.VehiculeCategory;
import org.example.domain.VehiculeSubCategory;
import org.example.services.VehiculeService;

import java.util.ArrayList;
import java.util.List;

public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    public boolean createCategory(String name) {
        vehiculeService.createCategory(name);
        return true;
    }

    public boolean createSubCategory(int categoryIndex, String name) {
        VehiculeCategory category = vehiculeService.findCategory(categoryIndex);
        vehiculeService.createSubCategory(category, name);
        return true;
    }

    public List<String> listVehiculeCategories() {
        List<String> results = new ArrayList<>();
        for (VehiculeCategory c : vehiculeService.listCategory()) {
            results.add(c.toString());
        }

        return results;
    }

    public List<String> listVehiculeSubCategories(int vehiculeCategoryIndex) {
        VehiculeCategory category = vehiculeService.findCategory(vehiculeCategoryIndex);
        List<String> results = new ArrayList<>();
        for (VehiculeSubCategory c : vehiculeService.listSubCategory(category)) {
            results.add(c.toString());
        }

        return results;
    }

}
