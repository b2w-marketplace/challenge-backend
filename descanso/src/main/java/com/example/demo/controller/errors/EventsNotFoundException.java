package com.example.demo.controller.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Evento não encontrado!")
public class EventsNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EventsNotFoundException() {
		super();
	}

	public EventsNotFoundException(String message) {
		super(message);
	}
	
}
