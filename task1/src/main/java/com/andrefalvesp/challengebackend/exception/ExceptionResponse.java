package com.andrefalvesp.challengebackend.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class ExceptionResponse {

  @JsonProperty("ERRORS")
  private Set<Error> errors;
  private String message;
  private String path;
  private String error;
  private int status;

  public ExceptionResponse(String message, HttpStatus httpStatus, String path) {
    this.message = message;
    this.status = httpStatus.value();
    this.error = httpStatus.getReasonPhrase();
    this.path = path;
  }
}

