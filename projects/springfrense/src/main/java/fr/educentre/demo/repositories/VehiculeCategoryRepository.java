package fr.educentre.demo.repositories;

import fr.educentre.demo.domain.VehiculeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeCategoryRepository extends CrudRepository<VehiculeCategory, Integer> {
}
