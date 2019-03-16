package com.rafaelfelix.b2wchallenge.controller.exception;

import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<?> httpServerError(HttpServerErrorException exception) {
		return ResponseEntity.badRequest()
        	   .body(new StandardError(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), new Date()));
    }
	
	@ExceptionHandler(UnknownHostException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<?> unknownHost(UnknownHostException exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        	   .body(new StandardError(HttpStatus.NOT_FOUND.value(), "URL não encontrada: ".concat(exception.getMessage()), new Date()));
    }

}
