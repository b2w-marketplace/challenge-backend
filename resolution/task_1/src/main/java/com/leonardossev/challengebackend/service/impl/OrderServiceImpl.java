package com.leonardossev.challengebackend.service.impl;

import com.leonardossev.challengebackend.client.OrderClient;
import com.leonardossev.challengebackend.model.Order;
import com.leonardossev.challengebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderClient orderClient;

    @Override
    public List<Order> listOrder(ZonedDateTime beginDate, ZonedDateTime finalDate) throws InvalidParameterException {
        if (beginDate.isAfter(finalDate)) {
            throw new InvalidParameterException();
        }

        var endOfFinalDate = finalDate.plusDays(1).minusSeconds(1);

        var orderList = orderClient.listOrder();

        return orderList
            .stream()
            .filter(order ->
                (order.getDate().isEqual(beginDate) || order.getDate().isAfter(beginDate)) &&
                (order.getDate().isEqual(endOfFinalDate) || order.getDate().isBefore(endOfFinalDate))
            )
            .collect(Collectors.toList());
    }
}
