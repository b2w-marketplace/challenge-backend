package br.com.rafael.challenge.handler;

import br.com.rafael.challenge.model.DefaultExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class, IllegalArgumentException.class})
    public ResponseEntity handleDateTimeParseException(Exception ex){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new DefaultExceptionResponse(ex.getMessage(), status), status);
    }



}
