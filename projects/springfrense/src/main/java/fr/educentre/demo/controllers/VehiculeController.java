package fr.educentre.demo.controllers;

import fr.educentre.demo.domain.VehiculeCategory;
import fr.educentre.demo.domain.VehiculeSubCategory;
import fr.educentre.demo.dto.VehiculeCategoryRequestDto;
import fr.educentre.demo.exceptions.VehiculeCategoryNotFoundException;
import fr.educentre.demo.exceptions.VehiculeSubCategoryNotFoundException;
import fr.educentre.demo.services.VehiculeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping("/categories")
    public ResponseEntity<VehiculeCategory> createCategory(@Valid @RequestBody VehiculeCategoryRequestDto dto) throws URISyntaxException {
        VehiculeCategory category = vehiculeService.createCategory(dto.getName());
        String categoryLocation = "/api/v1/categories/" + category.getId();
        return ResponseEntity.created(new URI(categoryLocation)).body(category); // Sending a 201 HTTP status code
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<VehiculeCategory> getCategory(@PathVariable int id) {
        VehiculeCategory category = vehiculeService.findCategoryById(id);
        return ResponseEntity.ok(category); // Sending a 200 HTTP status code
    }

    @PostMapping("/categories/{id}/sub-categories")
    public ResponseEntity<VehiculeSubCategory> createSubCategory(@PathVariable int id, @Valid @RequestBody VehiculeSubCategory vehiculeSubCategory) throws URISyntaxException, VehiculeCategoryNotFoundException {
        VehiculeCategory category = vehiculeService.findCategoryById(id);
        if (category == null) {
            throw new VehiculeCategoryNotFoundException();
        }
        VehiculeSubCategory subCategory = vehiculeService.createSubCategory(category, vehiculeSubCategory.getName());
        String categoryLocation = "/api/v1/sub-categories/" + subCategory.getId();
        return ResponseEntity.created(new URI(categoryLocation)).body(subCategory); // Sending a 201 HTTP status code
    }


    @GetMapping("/sub-categories/{id}")
    public ResponseEntity<VehiculeSubCategory> getSubCategory(@PathVariable int id) throws VehiculeSubCategoryNotFoundException {
        VehiculeSubCategory subCategory = vehiculeService.findSubCategoryById(id);
        if (subCategory == null) {
            throw new VehiculeSubCategoryNotFoundException();
        }
        return ResponseEntity.ok(subCategory); // Sending a 200 HTTP status code
    }

    @GetMapping("/categories")
    public ResponseEntity<Iterable<VehiculeCategory>> listCategories() {
        return ResponseEntity.ok(vehiculeService.listCategories()); // Sending a 200 HTTP status code
    }


    @GetMapping("/categories/{id}/sub-categories")
    public ResponseEntity<Iterable<VehiculeSubCategory>> listSubCategories(@PathVariable int id) throws VehiculeCategoryNotFoundException {
        VehiculeCategory category = vehiculeService.findCategoryById(id);
        if (category == null) {
            throw new VehiculeCategoryNotFoundException();
        }
        return ResponseEntity.ok(category.getSubCategories()); // Sending a 200 HTTP status code
    }

}
