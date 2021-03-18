package com.andrefalvesp.challengebackend.gateways;

import com.andrefalvesp.challengebackend.domains.Order;
import java.util.List;

public interface OrderGateway {

  List<Order> getOrderList();

}
