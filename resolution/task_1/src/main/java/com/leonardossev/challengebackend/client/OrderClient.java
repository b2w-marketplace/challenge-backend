package com.leonardossev.challengebackend.client;

import com.leonardossev.challengebackend.model.Order;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Headers("Content-Type: application/json")
@FeignClient(name = "order", url = "${challenge.backend.mocky.url:}")
public interface OrderClient {

    @RequestMapping(method = RequestMethod.GET)
    List<Order> listOrder();
}
