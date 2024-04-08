package com.example.CrudJPARest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CrudJpaRestApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void EmployeesTest() throws Exception{
		mockMvc.perform(get("/employees")).andDo(print());
	}

	@Test
	void EmployeeTest() throws Exception{
		mockMvc.perform(get("/employees/2")).andDo(print());
	}

	@Test
	void AddEmployeeTest() throws Exception{
		mockMvc.perform(post("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"John Doe\",\"position\":\"Engineer\"" +
						",\"birthday\":\"1992-12-22\",\"salary\":29000}"))
				.andDo(print());
	}

	@Test
	void DeleteTest() throws Exception{
		mockMvc.perform(delete("/employees/1")).andDo(print());
	}

	@Test
	void updateTest() throws Exception{
		mockMvc.perform(put("/employees")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"John Doe\",\"position\":\"Engineer\"" +
						",\"birthday\":\"1992-12-22\",\"salary\":59000}"))
				.andDo(print());
	}

}
