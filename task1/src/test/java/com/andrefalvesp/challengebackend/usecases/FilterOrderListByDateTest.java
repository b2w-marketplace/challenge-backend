package com.andrefalvesp.challengebackend.usecases;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.andrefalvesp.challengebackend.domains.Order;
import com.andrefalvesp.challengebackend.domains.OrderBuilder;
import com.andrefalvesp.challengebackend.exception.InvalidDateRangeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;


public class FilterOrderListByDateTest {

  final FilterOrderListByDate filterOrderByDate = new FilterOrderListByDate();

  @Test
  public void given_ValidDates_And_ValidOrderList_When_FilterOrderByDate_Then_Success() {

    final var beginDate = LocalDate.of(2020, Month.JULY, 29);
    final var finalDate = LocalDate.of(2021, Month.FEBRUARY, 10);
    final var orderList =
        Stream.of(OrderBuilder.ORDER_CELULAR(), OrderBuilder.ORDER_FOGAO(),
            OrderBuilder.ORDER_GELADEIRA())
            .collect(Collectors.toList());

    final var actual = filterOrderByDate.execute(orderList, beginDate, finalDate);

    orderList.remove(0);
    final var expected = orderList;

    assertThat(actual, is(expected));
    assertEquals(actual.size(), 2);

  }

  @Test
  public void given_EqualBeginDateAndFinalDate_When_FilterOrderByDate_Then_Success() {
    final var beginDate = LocalDate.of(2020, Month.JANUARY, 7);
    final var finalDate = LocalDate.of(2020, Month.JANUARY, 7);
    final var orderList = Stream.of(OrderBuilder.ORDER_CELULAR(), OrderBuilder.ORDER_FOGAO(),
        OrderBuilder.ORDER_GELADEIRA(), OrderBuilder.ORDER_TV()).collect(Collectors.toList());

    final var actual = filterOrderByDate.execute(orderList, beginDate, finalDate);

    orderList.remove(1);
    orderList.remove(1);

    final var expected = orderList;

    assertThat(actual, is(expected));
    assertEquals(actual.size(), 2);

  }

  @Test
  public void given_FinalDateIsLessThanBeginDate_When_FilterOrderByDate_Then_Exception() {
    final var beginDate = LocalDate.of(2020, Month.OCTOBER, 7);
    final var finalDate = LocalDate.of(2016, Month.JANUARY, 7);
    final var orderList = List.of(OrderBuilder.ORDER_CELULAR(), OrderBuilder.ORDER_FOGAO(),
        OrderBuilder.ORDER_GELADEIRA(), OrderBuilder.ORDER_TV());

    assertThrows(InvalidDateRangeException.class, (() ->
        filterOrderByDate.execute(orderList, beginDate, finalDate)));
  }

  @Test
  public void given_NullOrderList_When_FilterOrderByDate_Then_EmptyList() {
    final var beginDate = LocalDate.of(2020, Month.OCTOBER, 7);
    final var finalDate = LocalDate.of(2020, Month.OCTOBER, 14);
    final List<Order> orderList = null;

    final var orderListFilter = filterOrderByDate.execute(orderList, beginDate, finalDate);

    assertTrue(orderListFilter.isEmpty());
  }
}
