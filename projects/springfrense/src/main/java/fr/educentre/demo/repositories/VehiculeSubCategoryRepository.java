package fr.educentre.demo.repositories;

import fr.educentre.demo.domain.VehiculeSubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeSubCategoryRepository extends CrudRepository<VehiculeSubCategory, Integer> {
}
