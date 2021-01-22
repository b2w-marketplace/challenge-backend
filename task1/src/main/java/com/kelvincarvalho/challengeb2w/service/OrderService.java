package com.kelvincarvalho.challengeb2w.service;

import com.kelvincarvalho.challengeb2w.model.OrderDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    List<OrderDTO> listOrder(LocalDate beginData, LocalDate finalDate);

}
