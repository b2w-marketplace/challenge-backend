package com.andrefalvesp.challengebackend.usecases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.andrefalvesp.challengebackend.domains.OrderBuilder;
import com.andrefalvesp.challengebackend.gateways.OrderGatewayImpl;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.mockito.Mockito;

public class CrudOrderTest {

  private final OrderGatewayImpl orderGateway = Mockito.mock(OrderGatewayImpl.class);
  private final FilterOrderListByDate filterOrderListByDate = Mockito
      .mock(FilterOrderListByDate.class);
  private final CrudOrder crudOrder = new CrudOrder(orderGateway, filterOrderListByDate);

  @Test
  public void given_ValidParans_When_FindByDate_Then_Success() {

    final var beginDate = LocalDate.of(2020, Month.JULY, 29);
    final var finalDate = LocalDate.of(2021, Month.FEBRUARY, 10);
    final var orderList =
        Stream.of(OrderBuilder.ORDER_CELULAR(), OrderBuilder.ORDER_FOGAO(),
            OrderBuilder.ORDER_GELADEIRA())
            .collect(Collectors.toList());

    when(orderGateway.getOrderList()).thenReturn(orderList);
    when(filterOrderListByDate.execute(any(), any(), any())).thenReturn(orderList);

    final var actual = crudOrder.findByDate(beginDate, finalDate);
    final var expected = orderList;

    assertThat(actual, is(expected));
    verify(orderGateway, times(1)).getOrderList();
    verify(filterOrderListByDate, times(1)).execute(any(), any(), any());

  }
}