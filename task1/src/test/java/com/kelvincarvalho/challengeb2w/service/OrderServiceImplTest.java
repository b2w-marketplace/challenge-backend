package com.kelvincarvalho.challengeb2w.service;

import com.kelvincarvalho.challengeb2w.client.MockClient;
import com.kelvincarvalho.challengeb2w.exception.ApiException;
import com.kelvincarvalho.challengeb2w.model.OrderDTO;
import com.kelvincarvalho.challengeb2w.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class OrderServiceImplTest {

    @InjectMocks
    OrderServiceImpl orderService;

    @Mock
    MockClient mockClient;
    
    @Test
    public void shouldReturnListAllWithSuccess() {
       when(mockClient.listOrder()).thenReturn(orderListAll);

       var beginDate = LocalDate.of(2010,01,01);
       var finalDate = LocalDate.of(2020,01,01);

        var returnOrderList  = orderService.listOrder(beginDate, finalDate);

        assertEquals(orderListAll, returnOrderList);
    }

    @Test
    public void shouldReturnListFilteredWithSuccess() {
        when(mockClient.listOrder()).thenReturn(orderListAll);
        var orderListFiltered = Arrays.asList(orderForno);

        var beginDate = LocalDate.of(2016,10,5);
        var finalDate = LocalDate.of(2016,10,5);

        var returnOrderList  = orderService.listOrder(beginDate, finalDate);

        assertEquals(orderListFiltered, returnOrderList);
    }

    @Test
    public void shouldReturnEmptyListdWithSuccess() {
        when(mockClient.listOrder()).thenReturn(orderListAll);
        var orderEmptyList = Arrays.asList();

        var beginDate = LocalDate.of(2021,10,5);
        var finalDate = LocalDate.of(2021,10,5);

        var returnOrderList  = orderService.listOrder(beginDate, finalDate);

        assertEquals(orderEmptyList, returnOrderList);
    }

    @Test
    public void shouldReturnErrorWhenBeginDatesIsAfterFinalDate() {
        when(mockClient.listOrder()).thenReturn(orderListAll);
        var orderEmptyList = Arrays.asList();

        var beginDate = LocalDate.of(2018,12,20);
        var finalDate = LocalDate.of(2017,10,17);

        assertThrows(ApiException.class, () -> orderService.listOrder(beginDate, finalDate));
    }

    // MOCKS

    private final OrderDTO orderForno = OrderDTO.builder().name("Forno").code("13")
            .date(LocalDateTime.of(2016, 10, 5, 13, 20, 00)).build();
    private final OrderDTO orderFreezer = OrderDTO.builder().name("Freezer").code("12")
            .date(LocalDateTime.of(2016, 10, 10, 10, 10, 10)).build();
    private final OrderDTO orderFogao = OrderDTO.builder().name("Fogao").code("11")
            .date(LocalDateTime.of(2016, 10, 11, 15, 05, 05)).build();

    private final List<OrderDTO> orderListAll = Arrays.asList(orderForno, orderFogao, orderFreezer);
}
