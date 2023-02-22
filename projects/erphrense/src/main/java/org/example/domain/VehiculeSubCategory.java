package org.example.domain;

public class VehiculeSubCategory {

    private String name;

    private VehiculeCategory category;

    public VehiculeSubCategory(VehiculeCategory category, String name) {
        this.name = name;
        this.category = category;
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

    @Override
    public String toString() {
        return name;
    }
}
