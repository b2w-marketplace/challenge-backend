package com.andrefalvesp.challengebackend.usecases;

import com.andrefalvesp.challengebackend.domains.Order;
import com.andrefalvesp.challengebackend.gateways.OrderGateway;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrudOrder {

  private final OrderGateway orderGateway;
  private final FilterOrderListByDate filterOrderListByDate;

  public List<Order> findByDate(final LocalDate beginDate, final LocalDate finalDate) {
    return filterOrderListByDate.execute(
        orderGateway.getOrderList(),
        beginDate,
        finalDate);
  }
}