package br.com.challenge.backend.controller;


import br.com.challenge.backend.controller.exception.ExceptionResponse;
import br.com.challenge.backend.controller.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerTest {


	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private Environment environment;

	@Test
	public void testFilterByDate() {
		ResponseEntity<List<Item>> response =
				restTemplate.exchange("/item?begindate=05-10-2016&finaldate=07-10-2016",
						HttpMethod.GET, null, new ParameterizedTypeReference<List<Item>>() {
						});
		Assertions.assertTrue(response.getStatusCodeValue()  == 200);
		Assertions.assertNotNull(response.getBody());
	}

	@Test
	public void testFilterWithInvalidDate() {
		ResponseEntity<ExceptionResponse> response =
				restTemplate.exchange("/item?begindate=05-10-2016&finaldate=07-0-2016",
						HttpMethod.GET, null, ExceptionResponse.class);
		Assertions.assertEquals(response.getStatusCodeValue(), 500);
		Assertions.assertEquals(response.getBody().getMessage(), "Text '07-0-2016' could not be parsed at index 3");
	}

}
