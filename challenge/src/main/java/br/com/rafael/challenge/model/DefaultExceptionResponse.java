package br.com.rafael.challenge.model;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public class DefaultExceptionResponse {

    private int status;
    private String message;

    public DefaultExceptionResponse(String message, @NotNull HttpStatus status){
        setStatus(status);
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status.value();
    }
}
