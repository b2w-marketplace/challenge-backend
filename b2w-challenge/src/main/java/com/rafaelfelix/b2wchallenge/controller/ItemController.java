package com.rafaelfelix.b2wchallenge.controller;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelfelix.b2wchallenge.dto.ProductDTO;
import com.rafaelfelix.b2wchallenge.service.ItemService;

/**
 * Classe de controle dos serviços
 * 
 * @author rafaelfelixmoraes
 *
 */

@RestController
@RequestMapping(value = "/challenge-backend")
public class ItemController {
	
	@Autowired
    private ItemService itemService;
	

	@GetMapping(value = "/item", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> findByDateInterval(
			@RequestParam(name = "begindate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate beginDate,
			@RequestParam(name = "finaldate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate finalDate) throws UnknownHostException {
		
		List<ProductDTO> productsList = itemService.searchFilter(beginDate, finalDate);
		
		return ResponseEntity.ok(productsList);
	}
}
