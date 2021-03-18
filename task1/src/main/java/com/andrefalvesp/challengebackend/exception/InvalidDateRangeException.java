package com.andrefalvesp.challengebackend.exception;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidDateRangeException extends RuntimeException {

  private final LocalDate beginDate;
  private final LocalDate finalDate;

  public String getMessage() {
    return "Invalid date range. Final date " + finalDate + " is less than begin date '" + beginDate;
  }
}