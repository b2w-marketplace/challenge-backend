package br.com.bonaldo.backendchallenge.gateways;

import br.com.bonaldo.backendchallenge.gateways.http.json.OrderItemResponse;

import java.util.List;

public interface OrderGateway {
    List<OrderItemResponse> getOrderItems();
}
