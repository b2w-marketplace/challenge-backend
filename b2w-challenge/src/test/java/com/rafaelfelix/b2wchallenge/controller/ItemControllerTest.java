package com.rafaelfelix.b2wchallenge.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void findItens() throws Exception {
		String apiTestUrl = "http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016";
		mockMvc.perform(get(apiTestUrl))
			   .andExpect(status().isOk())
			   .andExpect(jsonPath("$[0].code", equalTo(5)))
			   .andExpect(jsonPath("$[0].name", equalTo("Impressora")))
			   .andExpect(jsonPath("$[1].code", equalTo(6)))
			   .andExpect(jsonPath("$[1].name", equalTo("Fifa2017")));
	}

}
