package spring.boot.jenkins;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vvz.springboot.ThemeParkRideApplication;

import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ThemeParkRideApplication.class)
@AutoConfigureMockMvc
public class ThemeParkApplicationIT {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getsAllRides() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/rides")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
	}
	
	@Test
	public void getSingleRide() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/ride/1")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
	}
	
	@Test
	public void returnsNotFoundForInvalidSingleRide() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/ride/4")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound())
		.andReturn();
	}
	
	@Test
	public void addsNewRides() throws Exception {
		String newRide = "{\"name\":\"Monorail\", \"description\":\"Sedate traveling\", \"thrillFactor\":2, \"vomitFactor\":-7}";
		this.mockMvc.perform(MockMvcRequestBuilders.post("/ride")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newRide)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
	}
}
