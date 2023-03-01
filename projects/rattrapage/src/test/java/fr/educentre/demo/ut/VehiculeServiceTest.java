package fr.educentre.demo.ut;

import fr.educentre.demo.domain.VehiculeCategory;
import fr.educentre.demo.repositories.VehiculeCategoryRepository;
import fr.educentre.demo.services.VehiculeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
public class VehiculeServiceTest {

    @Autowired
    private VehiculeService vehiculeService;

    @MockBean
    private VehiculeCategoryRepository mockVehiculeCategoryRepository;

    @Test
    public void testCreateCategory() throws Exception {

        // Defining the mock with Mokito
        VehiculeCategory category = new VehiculeCategory();
        category.setId(1);
        category.setName("Balley");
        Mockito.when(mockVehiculeCategoryRepository.save(ArgumentMatchers.any(VehiculeCategory.class))).thenReturn(category);

        VehiculeCategory result = vehiculeService.createCategory("Cars");
        Assertions.assertEquals("Balley", result.getName());
    }

}
