package fr.educentre.demo.e2e;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class VehiculeTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testCreateVehiculeCategory() throws Exception {
		String requestBody = "{\"name\": \"Cars\"}";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/api/v1/categories")
						.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(status().isCreated())
				.andReturn();
		String responseBody = result.getResponse().getContentAsString();
		Assertions.assertTrue(responseBody.contains("Cars"));
	}

	@Test
	public void testListVehiculeCategories() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/api/v1/categories")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		String responseBody = result.getResponse().getContentAsString();
		Assertions.assertEquals("[]", responseBody);
	}

}
