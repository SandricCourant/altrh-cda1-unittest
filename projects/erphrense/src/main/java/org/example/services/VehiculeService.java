package org.example.services;

import org.example.domain.VehiculeCategory;
import org.example.domain.VehiculeSubCategory;
import org.example.repositories.VehiculeCategoryRepository;
import org.example.repositories.VehiculeSubCategoryRepository;

import java.util.List;

public class VehiculeService {

    private final VehiculeCategoryRepository vehiculeCategoryRepository;
    private final VehiculeSubCategoryRepository vehiculeSubCategoryRepository;

    public VehiculeService(VehiculeCategoryRepository vehiculeCategoryRepository,
                           VehiculeSubCategoryRepository vehiculeSubCategoryRepository) {

        this.vehiculeCategoryRepository = vehiculeCategoryRepository;
        this.vehiculeSubCategoryRepository = vehiculeSubCategoryRepository;
    }

    public List<VehiculeCategory> listCategory() {
        return vehiculeCategoryRepository.provide();
    }

    public List<VehiculeSubCategory> listSubCategory(VehiculeCategory vehiculeCategory) {
        return vehiculeSubCategoryRepository.findBy(vehiculeCategory);
    }

    public VehiculeCategory findCategory(int index) {
        return vehiculeCategoryRepository.find(index);
    }

    public VehiculeSubCategory findSubCateogry(VehiculeCategory vehiculeCategory, int index) {
        return vehiculeSubCategoryRepository.find(vehiculeCategory, index);
    }

    public VehiculeCategory createCategory(String name) {
        return vehiculeCategoryRepository.create(name);
    }

    public VehiculeSubCategory createSubCategory(VehiculeCategory category, String name) {
        return vehiculeSubCategoryRepository.create(category, name);
    }

}
