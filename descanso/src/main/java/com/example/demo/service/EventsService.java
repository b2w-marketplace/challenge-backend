package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Events;
import com.example.demo.repository.EventsRepository;


@Service
public class EventsService {

	@Autowired
	private EventsRepository repository;

	public Page<Events> getAll(int page, int size) {
		return repository.findAll(PageRequest.of(page, size));
	}
	
	public Events create(Events events) {
	
		return	repository.save(events);
		
		
	}


}
