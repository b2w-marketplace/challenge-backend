package com.andrefalvesp.challengebackend.domains;

import java.time.LocalDate;
import java.time.Month;

public class OrderBuilder {

  public static Order ORDER_FOGAO() {
    return Order.builder()
        .code("1")
        .name("Fogão")
        .dimension(DimensionBuilder.DIMENSION_DEFAULT())
        .date(LocalDate.of(2020, Month.OCTOBER, 12))
        .build();
  }

  public static Order ORDER_GELADEIRA() {
    return Order.builder()
        .code("2")
        .name("Geladeira")
        .dimension(DimensionBuilder.DIMENSION_DEFAULT())
        .date(LocalDate.of(2020, Month.NOVEMBER, 11))
        .build();
  }

  public static Order ORDER_CELULAR() {
    return Order.builder()
        .code("3")
        .name("Celular")
        .dimension(DimensionBuilder.DIMENSION_DEFAULT())
        .date(LocalDate.of(2020, Month.JANUARY, 7))
        .build();
  }

  public static Order ORDER_TV() {
    return Order.builder()
        .code("4")
        .name("TV")
        .dimension(DimensionBuilder.DIMENSION_DEFAULT())
        .date(LocalDate.of(2020, Month.JANUARY, 7))
        .build();
  }
}