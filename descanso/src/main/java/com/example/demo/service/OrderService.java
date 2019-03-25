package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.OrderClient;
import com.example.demo.controller.dtos.OrderDTO;

@Service
public class OrderService {
	
	@Autowired
	private OrderClient orders;
	
	public List<OrderDTO> getAllOrders() {
		return orders.getAll();
	}
	
	public List<OrderDTO> getAllOrdersDate(String begindate,String finaldate) {
		if(begindate == null && finaldate == null) {
			return orders.getAll();
		}
		return orders.getAll();
	}
	

}
