package com.andrefalvesp.challengebackend.controllers;

import static org.springframework.http.HttpStatus.OK;

import com.andrefalvesp.challengebackend.domains.Order;
import com.andrefalvesp.challengebackend.usecases.CrudOrder;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge-backend/item")
@RequiredArgsConstructor
public class OrderController {

  private static final String BEGINDATE_PARAM = "beginDate";
  private static final String FINALDATE_PARAM = "finalDate";

  private final CrudOrder crudOrder;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(OK)
  public List<Order> findByDate(
      @RequestParam(name = BEGINDATE_PARAM)
      @DateTimeFormat(pattern = "dd-MM-yyyy") final LocalDate beginDate,
      @RequestParam(name = FINALDATE_PARAM)
      @DateTimeFormat(pattern = "dd-MM-yyyy") final LocalDate finalDate) {

    return crudOrder.findByDate(beginDate, finalDate);
  }
}