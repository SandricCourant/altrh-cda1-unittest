package fr.educentre.demo.services;

import fr.educentre.demo.domain.VehiculeCategory;
import fr.educentre.demo.domain.VehiculeSubCategory;
import fr.educentre.demo.repositories.VehiculeCategoryRepository;
import fr.educentre.demo.repositories.VehiculeSubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeCategoryRepository vehiculeCategoryRepository;

    @Autowired
    private VehiculeSubCategoryRepository vehiculeSubCategoryRepository;

    public Iterable<VehiculeCategory> listCategories() {
        return vehiculeCategoryRepository.findAll();
    }

    public VehiculeCategory findCategoryById(int id) {
        return vehiculeCategoryRepository.findById(id).orElse(null);
    }

    public VehiculeSubCategory findSubCategoryById(int id) {
        return vehiculeSubCategoryRepository.findById(id).orElse(null);
    }

    public VehiculeCategory createCategory(String name) {
        VehiculeCategory category = new VehiculeCategory();
        category.setName(name);
        return vehiculeCategoryRepository.save(category);
    }

    public VehiculeSubCategory createSubCategory(VehiculeCategory category, String name) {
        VehiculeSubCategory subCategory = new VehiculeSubCategory();
        subCategory.setCategory(category);
        subCategory.setName(name);
        return vehiculeSubCategoryRepository.save(subCategory);
    }

}
