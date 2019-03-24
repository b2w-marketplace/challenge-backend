package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.OrderClient;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderClient orders;
	
	@GetMapping 
	public List<JsonNode> getAllOrders() {
		return orders.getAll();
	}

}
