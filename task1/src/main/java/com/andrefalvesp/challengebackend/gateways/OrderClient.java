package com.andrefalvesp.challengebackend.gateways;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.andrefalvesp.challengebackend.domains.Order;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${feign.order.name}", url = "${feign.order.url}",
    fallbackFactory = OrderClientFallback.class)
public interface OrderClient {

  @GetMapping(value = "/5817803a1000007d01cc7fc9", produces = APPLICATION_JSON_VALUE)
  List<Order> getOrderList();
}