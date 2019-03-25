package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Events;
import com.example.demo.service.EventsService;

@RestController
@RequestMapping("/events")
public class EventsController {

	@Autowired
	private EventsService service;
	
	@GetMapping()
	public Page<Events> getAll(int page, int size) {
		return service.getAll(page, size);
	}
	
	@GetMapping("/filters")
	public List<Events> getAllFilters() {
		return service.findAllEventsType();
	}
	
	
	
    @PostMapping
    public Events create(@RequestBody Events events) {
		return  service.create(events);
	}
    
    @PostMapping("/createlist")
    public List<Events> createList(@RequestBody List<Events> events) {
    	 List<Events> result = new ArrayList<>();
    	 events.forEach(e ->{
    		 result.add(service.create(e));
    	 });
    	 return result;
	}



}
