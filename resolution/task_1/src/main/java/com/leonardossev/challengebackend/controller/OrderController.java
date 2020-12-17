package com.leonardossev.challengebackend.controller;

import com.leonardossev.challengebackend.model.Order;
import com.leonardossev.challengebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/challenge-backend", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "item")
    public List<Order> listOrder(@RequestParam ZonedDateTime beginDate, @RequestParam ZonedDateTime finalDate) {
        return orderService.listOrder(beginDate, finalDate);
    }
}
