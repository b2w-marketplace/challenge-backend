package com.example.demo.client;



import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.controller.dtos.OrderDTO;

@FeignClient(name = "order", url = "http://www.mocky.io/v2/5817803a1000007d01cc7fc9")
public interface OrderClient {

	@GetMapping
	List<OrderDTO>  getAll();

}
