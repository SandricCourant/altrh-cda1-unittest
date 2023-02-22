package org.example.domain;

import java.util.List;

public class VehiculeCategory {

    private String name;
    private List<VehiculeSubCategory> subCategories;

    public VehiculeCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VehiculeSubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<VehiculeSubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o.getClass() != this.getClass()) {
            return false;
        }

        VehiculeCategory other = (VehiculeCategory) o; // casting

        if (!other.getName().equals(this.getName())) {
            return false;
        }

        return true;
    }
}
