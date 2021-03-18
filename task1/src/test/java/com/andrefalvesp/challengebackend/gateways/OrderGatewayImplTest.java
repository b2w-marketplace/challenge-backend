package com.andrefalvesp.challengebackend.gateways;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.andrefalvesp.challengebackend.domains.OrderBuilder;
import com.andrefalvesp.challengebackend.usecases.CrudOrder;
import com.andrefalvesp.challengebackend.usecases.FilterOrderListByDate;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.mockito.Mockito;

public class OrderGatewayImplTest {

  private final OrderClient orderClient = Mockito.mock(OrderClient.class);
  private final OrderGatewayImpl orderGateway = new OrderGatewayImpl(orderClient);

  @Test
  public void given_ValidParans_When_GetOrderList_Then_Success() {

    final var orderList =
        Stream.of(OrderBuilder.ORDER_CELULAR(), OrderBuilder.ORDER_FOGAO(),
            OrderBuilder.ORDER_GELADEIRA())
            .collect(Collectors.toList());

    when(orderClient.getOrderList()).thenReturn(orderList);

    final var actual = orderGateway.getOrderList();
    final var expected = orderList;

    assertThat(actual, is(expected));
    verify(orderClient, times(1)).getOrderList();
  }
}