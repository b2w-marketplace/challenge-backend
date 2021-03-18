package com.andrefalvesp.challengebackend.gateways;

import com.andrefalvesp.challengebackend.domains.Order;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderGatewayImpl implements OrderGateway {

  @Autowired
  private final OrderClient orderClient;

  @Override
  public List<Order> getOrderList() {
    return orderClient.getOrderList();
  }
}