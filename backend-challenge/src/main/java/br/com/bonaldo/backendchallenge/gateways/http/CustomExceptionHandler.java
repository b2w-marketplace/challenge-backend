package br.com.bonaldo.backendchallenge.gateways.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.DateTimeException;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DateTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<String> handleInvalidDateException(HttpServletRequest req, Exception ex) {
        log.info("Invalid date format on request: {}, with params: {}, exception: {}", req.getRequestURI(), req.getQueryString(), ex.getMessage());
        return ResponseEntity.badRequest().body("Invalid date format");
    }
}