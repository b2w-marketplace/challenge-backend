package br.com.b2w.marketplace.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.b2w.marketplace.BaseTest;
import br.com.b2w.marketplace.component.ItemFilterComponent;
import br.com.b2w.marketplace.service.MockyAPIService;

@WebAppConfiguration
public class ItemRestControllerTest extends BaseTest {

	private MockMvc mockMvc;

	@Autowired
	private MockyAPIService mockyAPIService;
	
	@Autowired
	private ItemFilterComponent itemFilterComponent;

	@Before
	public void setUp() throws Exception {

		mockMvc = MockMvcBuilders.standaloneSetup(new ItemRestController(mockyAPIService, itemFilterComponent)).build();

	}

	@Test
	public void testRecuperarItens() throws Exception {

		this.mockMvc.perform(get("/item?begindate=05-10-2016&finaldate=10-10-2016"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$[0].name").value("Impressora"))
			.andExpect(jsonPath("$[0].date").value("2016-10-05T14:30:37.040Z"))
			.andExpect(jsonPath("$[1].name").value("Fifa2017"))
			.andExpect(jsonPath("$[1].date").value("2016-10-06T14:30:37.040Z"))
			.andExpect(jsonPath("$[2].name").value("Notebook"))
			.andExpect(jsonPath("$[2].date").value("2016-10-07T14:30:37.040Z"))
			.andExpect(jsonPath("$[3].name").value("Tablet"))
			.andExpect(jsonPath("$[3].date").value("2016-10-08T14:30:37.040Z"))
			.andExpect(jsonPath("$[4].name").value("Computador"))
			.andExpect(jsonPath("$[4].date").value("2016-10-09T14:30:37.040Z"))
			.andExpect(jsonPath("$[5].name").value("Guarda-Roupa"))
			.andExpect(jsonPath("$[5].date").value("2016-10-10T14:30:37.040Z"))
			.andExpect(jsonPath("$", hasSize(6)));

	}

}
