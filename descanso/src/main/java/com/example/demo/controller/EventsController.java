package com.example.demo.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dtos.EventsRequest;
import com.example.demo.controller.errors.EventsNotFoundException;
import com.example.demo.domain.Events;
import com.example.demo.service.EventsService;

@RestController
@RequestMapping("/agendamento")
public class EventsController {


	private static final String NOT_FOUND = "Agendamento não encontrado!";
	@Autowired
	private EventsService service;



	@GetMapping()
	public Page<Events> getAll(int page, int size) {
		return service.getAll(page, size);
	}



}
