package br.com.bonaldo.backendchallenge.gateways.http;

import br.com.bonaldo.backendchallenge.gateways.OrderGateway;
import br.com.bonaldo.backendchallenge.gateways.http.json.OrderItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderGatewayAPI implements OrderGateway {

    @Value("${integration.order-api.url}")
    private String API_URL;

    private final RestTemplate restTemplate;

    @Override
    public List<OrderItemResponse> getOrderItems() {
        ResponseEntity<List<OrderItemResponse>> response = restTemplate
                .exchange(API_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<OrderItemResponse>>() {});
        return response.getBody();
    }
}