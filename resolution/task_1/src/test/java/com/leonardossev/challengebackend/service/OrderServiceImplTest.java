package com.leonardossev.challengebackend.service;

import com.leonardossev.challengebackend.client.OrderClient;
import com.leonardossev.challengebackend.model.Dimension;
import com.leonardossev.challengebackend.model.Order;
import com.leonardossev.challengebackend.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.security.InvalidParameterException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class OrderServiceImplTest {

    @Mock
    private OrderClient orderClient;

    @InjectMocks
    private OrderServiceImpl orderService;

    private final DateTimeFormatter ZONED_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

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
            .date(ZonedDateTime.parse("2016-10-05T14:30:37.040Z", ZONED_DATE_TIME_FORMATTER))
            .dimension(ORDER_DIMENSION)
            .build(),
        Order.builder()
            .name("Fifa2017")
            .code("6")
            .date(ZonedDateTime.parse("2016-10-06T14:30:37.040Z", ZONED_DATE_TIME_FORMATTER))
            .dimension(ORDER_DIMENSION)
            .build(),
        Order.builder()
            .name("Notebook")
            .code("7")
            .date(ZonedDateTime.parse("2016-10-07T14:30:37.040Z", ZONED_DATE_TIME_FORMATTER))
            .dimension(ORDER_DIMENSION)
            .build()
    );

    private final List<Order> FILTERED_ORDER_LIST = Collections.singletonList(
        Order.builder()
            .name("Impressora")
            .code("5")
            .date(ZonedDateTime.parse("2016-10-05T14:30:37.040Z", ZONED_DATE_TIME_FORMATTER))
            .dimension(ORDER_DIMENSION)
            .build()
    );

    @Test
    public void shouldThrowExceptionWhenBeginDateIsGreaterThanFinalDate() throws InvalidParameterException {
        var beginDate = ZonedDateTime.now().plusDays(1);
        var finalDate = ZonedDateTime.now();

        assertThrows(InvalidParameterException.class, () -> orderService.listOrder(beginDate, finalDate));
    }

    @Test
    public void shouldReturnOrderListWhenProvidedDatesAreValid() {
        prepareOrderList();

        var beginDate = ZonedDateTime.parse("2016-10-01T14:30:37.040Z", ZONED_DATE_TIME_FORMATTER);
        var finalDate = ZonedDateTime.parse("2016-10-10T14:30:37.040Z", ZONED_DATE_TIME_FORMATTER);

        var orderList = orderService.listOrder(beginDate, finalDate);

        assertNotNull(orderList);
    }

    @Test
    public void shouldReturnFilteredOrderListWhenProvidedDatesAreValid() {
        prepareOrderList();

        var beginDate = ZonedDateTime.parse("2016-10-05T00:00:00.040Z", ZONED_DATE_TIME_FORMATTER);
        var finalDate = ZonedDateTime.parse("2016-10-05T00:00:00.040Z", ZONED_DATE_TIME_FORMATTER);

        var orderList = orderService.listOrder(beginDate, finalDate);

        assertEquals(FILTERED_ORDER_LIST.size(), orderList.size());
    }

    private void prepareOrderList() {
        when(orderClient.listOrder()).thenReturn(ORDER_LIST);
    }
}
