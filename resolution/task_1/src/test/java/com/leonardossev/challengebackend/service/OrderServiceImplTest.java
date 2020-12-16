package com.leonardossev.challengebackend.service;

import com.leonardossev.challengebackend.model.Dimension;
import com.leonardossev.challengebackend.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class OrderServiceImplTest {

    @Mock
    private OrderClient orderClient;

    @InjectMocks
    private OrderServiceImpl orderService;

    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final Dimension ORDER_DIMENSION =  Dimension.builder()
        .weight(10.5f)
        .height(10.5f)
        .width(10.5f)
        .length(10.5f)
        .build();

    private final List<Order> ORDER_LIST = Arrays.asList(
        Order.builder()
            .name("Impressora")
            .code("5")
            .date(LocalDateTime.parse("2016-10-05 14:30:37", DATE_TIME_FORMATTER))
            .dimension(ORDER_DIMENSION)
            .build(),
        Order.builder()
            .name("Fifa2017")
            .code("6")
            .date(LocalDateTime.parse("2016-10-07 14:30:37", DATE_TIME_FORMATTER))
            .dimension(ORDER_DIMENSION)
            .build(),
        Order.builder()
            .name("Notebook")
            .code("7")
            .date(LocalDateTime.parse("2016-10-08 14:30:37", DATE_TIME_FORMATTER))
            .dimension(ORDER_DIMENSION)
            .build()
    );

    @Test
    public void shouldThrowExceptionWhenBeginDateIsGreaterThanFinalDate() throws InvalidParameterException {
        var beginDate = LocalDateTime.now().plusDays(1);
        var finalDate = LocalDateTime.now();

        assertThrows(InvalidParameterException.class, () -> orderService.listOrder(beginDate, finalDate));
    }

    @Test
    public void shouldReturnOrderListWhenProvidedDatesAreValid() {
        var beginDate = LocalDateTime.parse("2016-10-00 00:00:00", DATE_TIME_FORMATTER);
        var finalDate = LocalDateTime.parse("2016-10-10 00:00:00", DATE_TIME_FORMATTER);

        var orderList = orderService.listOrder(beginDate, finalDate);

        assertTrue(orderList instanceof List);
    }

    @Test
    public void shouldReturnFilteredOrderListWhenProvidedDatesAreValid() {
        // TODO: implement
    }

    private void prepareOrderList() {
        var beginDate = LocalDateTime.parse("2016-10-00 00:00:00", DATE_TIME_FORMATTER);
        var finalDate = LocalDateTime.parse("2016-10-10 00:00:00", DATE_TIME_FORMATTER);

        Mockito.when(orderClient.listOrder(beginDate, finalDate)).thenReturn(ORDER_LIST);
    }
}
