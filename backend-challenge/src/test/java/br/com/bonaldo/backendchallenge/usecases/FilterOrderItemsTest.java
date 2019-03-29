package br.com.bonaldo.backendchallenge.usecases;

import br.com.bonaldo.backendchallenge.domains.OrderItem;
import br.com.bonaldo.backendchallenge.gateways.OrderGateway;
import br.com.bonaldo.backendchallenge.gateways.http.json.DimensionResponse;
import br.com.bonaldo.backendchallenge.gateways.http.json.OrderItemResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FilterOrderItemsTest {

    public static final String ITEM_DE_HOJE = "Today";

    @InjectMocks
    private FilterOrderItems filterOrderItems;

    @Mock
    private OrderGateway orderGateway;

    @Test
    public void FilterOrderItemsShouldReturnWithOnlyOneItemWithinDateRange() {
        OrderItemResponse expectedItem = OrderItemResponse.builder()
                .date(LocalDateTime.now())
                .name(ITEM_DE_HOJE)
                .dimension(new DimensionResponse())
                .build();

        OrderItemResponse futureItem = OrderItemResponse.builder()
                .date(LocalDateTime.now().minusDays(1))
                .name("Tomorrow")
                .dimension(new DimensionResponse())
                .build();

        OrderItemResponse pastItem = OrderItemResponse.builder()
                .date(LocalDateTime.now().plusDays(1))
                .name("Yesterday")
                .dimension(new DimensionResponse())
                .build();

        List<OrderItemResponse> response = new ArrayList<>();
        Collections.addAll(response, expectedItem, futureItem, pastItem);

        Mockito.when(orderGateway.getOrderItems()).thenReturn(response);

        List<OrderItem> result = filterOrderItems.execute(LocalDate.now(), LocalDate.now());

        Assert.assertEquals(1, result.size());
        Assert.assertNotNull(result.get(0));
        Assert.assertEquals(result.get(0).getName(), ITEM_DE_HOJE);
    }
}