package com.leonardossev.challengebackend.service;

import com.leonardossev.challengebackend.model.Order;

import java.security.InvalidParameterException;
import java.time.ZonedDateTime;
import java.util.List;

public interface OrderService {

    List<Order> listOrder(ZonedDateTime beginDate, ZonedDateTime finalDate) throws InvalidParameterException;
}
