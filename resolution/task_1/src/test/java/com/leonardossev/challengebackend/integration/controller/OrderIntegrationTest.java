package com.leonardossev.challengebackend.integration.controller;

import com.leonardossev.challengebackend.integration.BaseIntegrationTest;
import com.leonardossev.challengebackend.model.Order;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderIntegrationTest extends BaseIntegrationTest {

    protected final String PATH = "/challenge-backend/item";

    @Test
    void listFilteredOrderList() throws ParseException {
        Response response = RestAssured.given()
            .queryParam("beginDate", "05-10-2016")
            .queryParam("finalDate", "06-10-2016")
            .contentType(ContentType.JSON)
            .expect()
            .statusCode(200)
            .when()
            .get(PATH);

        var orderList = Arrays.asList(response.getBody().as(Order[].class));

        assertEquals(2, orderList.size());
    }

}
