package com.kelvincarvalho.challengeb2w.service.impl;

import com.kelvincarvalho.challengeb2w.client.MockClient;
import com.kelvincarvalho.challengeb2w.exception.ApiException;
import com.kelvincarvalho.challengeb2w.model.OrderDTO;
import com.kelvincarvalho.challengeb2w.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    MockClient mockClient;

    @Override
    public List<OrderDTO> listOrder(LocalDate beginData, LocalDate finalDate) {
        if(beginData.isAfter(finalDate))
            throw new ApiException("Start date must be less than end date");

        var listOrder = mockClient.listOrder();

        return listOrder.stream().filter(order -> isBetweenDate(beginData, finalDate, order.getDate()))
                .collect(Collectors.toList());
    }

    private boolean isBetweenDate(LocalDate beginData, LocalDate finalDate, LocalDateTime orderDate) {
        return orderDate.isAfter(beginData.atStartOfDay()) &&
                orderDate.isBefore(finalDate.atTime(23,59,59));
    }
}
