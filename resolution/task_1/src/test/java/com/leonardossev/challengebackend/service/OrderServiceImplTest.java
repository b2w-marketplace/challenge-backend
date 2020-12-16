package com.leonardossev.challengebackend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
public class OrderServiceImplTest {

    @Mock
    private OrderClient orderClient;

    @InjectMocks
    private OrderServiceImpl orderService;

    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final Dimension ORDER_DIMENSION =  Dimension.builder()
        .weight(10.5)
        .height(10.5)
        .width(10.5)
        .length(10.5)
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
            .name(1L)
            .code()
            .date(LocalDateTime.parse("2016-10-08 14:30:37", DATE_TIME_FORMATTER))
            .dimension(ORDER_DIMENSION)
            .build()
    );

    @Test
    public void shouldThrowExceptionWhenBeginDateIsGreaterThanFinalDate() {
        // TODO: implement
    }

    @Test
    public void shouldReturnOrderListWhenProvidedDatesAreValid() {
        // TODO: implement
    }
}
