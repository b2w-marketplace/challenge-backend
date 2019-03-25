package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<Events> findAllEventsType() {
			return repository.findAllEventsType();
	}
	
	public Events create(Events events) {
		return	repository.save(events);
	}


}
