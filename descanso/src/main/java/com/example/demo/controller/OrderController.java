package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dtos.OrderDTO;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping 
	public List<OrderDTO> getAllOrdersDate(	@RequestParam(name = "begindate", required = false) String begindate, @RequestParam(name = "finaldate", required = false) String finaldate) {
		System.out.println(begindate);
		return service.getAllOrdersDate(begindate,finaldate);
	}
	
	@GetMapping("/all") 
	public List<OrderDTO> getAllOrders() {
		return service.getAllOrders();
	}

}
