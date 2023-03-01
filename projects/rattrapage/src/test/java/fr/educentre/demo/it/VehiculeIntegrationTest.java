package fr.educentre.demo.it;

import fr.educentre.demo.domain.VehiculeCategory;
import fr.educentre.demo.domain.VehiculeSubCategory;
import fr.educentre.demo.repositories.VehiculeCategoryRepository;
import fr.educentre.demo.repositories.VehiculeSubCategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
class VehiculeIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VehiculeCategoryRepository mockVehiculeCategoryRepository;
    @MockBean
    private VehiculeSubCategoryRepository mockVehiculeSubCategoryRepository;

    @Test
    public void testCreateVehiculeCategory() throws Exception {

        // Defining the mock with Mokito
        VehiculeCategory category = new VehiculeCategory();
        category.setId(1);
        category.setName("Balley");
        Mockito.when(
			mockVehiculeCategoryRepository.save(ArgumentMatchers.any(VehiculeCategory.class))
		).thenReturn(category);

        // Testing
        String requestBody = "{\"name\": \"Cars\"}";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/api/v1/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
        String responseBody = result.getResponse().getContentAsString();
        Assertions.assertTrue(responseBody.contains("Balley"));
    }

    @Test
    public void testCreateVehiculeSubCategory() throws Exception {
        // 1. Mocking VehiculeCategoryRepository
        VehiculeCategory category = new VehiculeCategory();
        category.setId(1);
        category.setName("Jet");
        Mockito.when(
                mockVehiculeCategoryRepository.findById(2)
        ).thenReturn(Optional.of(category));

        // 2. Mocking VehiculeSubCategoryRepository
        VehiculeSubCategory subCategory = new VehiculeSubCategory();
        subCategory.setId(1);
        subCategory.setName("Eco");
        Mockito.when(
                mockVehiculeSubCategoryRepository.save(ArgumentMatchers.any(VehiculeSubCategory.class))
        ).thenReturn(subCategory);

        // 3. Testing
        String requestBody = "{\"name\": \"Eco\"}";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/api/v1/categories/2/sub-categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
        String responseBody = result.getResponse().getContentAsString();
        Assertions.assertTrue(responseBody.contains("Eco"));
    }

}
