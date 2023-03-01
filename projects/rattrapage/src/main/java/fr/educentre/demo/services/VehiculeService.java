package fr.educentre.demo.services;


import fr.educentre.demo.domain.VehiculeCategory;
import fr.educentre.demo.domain.VehiculeSubCategory;

public interface VehiculeService {

    Iterable<VehiculeCategory> listCategories();
    VehiculeCategory findCategoryById(int id);
    VehiculeSubCategory findSubCategoryById(int id);
    VehiculeCategory createCategory(String name);
    VehiculeSubCategory createSubCategory(VehiculeCategory category, String name);

}
