package com.example.demo;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.example.demo.domain.Events;
import com.example.demo.service.EventsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventsTest {
	
	@Autowired
	private EventsService service;
	
	@Value("${api.baseURI}")
	private String baseURI;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setup() {


		RestAssured.baseURI = baseURI;

		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON).build();
	}
	
	
	@Test
	public void createSimplePayment() throws Throwable { // @formatter:off
		JsonNode json = getRequestBody("events.json");

		 given().			
			body(json).
		when().
	       post("v1/events").
	    then().
	    	statusCode(201);
		
	} // @formatter:on
	
	
	@Test
	public void createCreditTest() {
		Events events = new Events();
		events.setEventType(1);
		events.setTime(new Date());
		events.setValue(12);

		Events result = service.create(events);
	}
	
	
	private JsonNode getRequestBody(String filename) throws Throwable {
		File src = ResourceUtils.getFile("classpath:json/" + filename);
		return objectMapper.readValue(src, JsonNode.class);
	}

}
