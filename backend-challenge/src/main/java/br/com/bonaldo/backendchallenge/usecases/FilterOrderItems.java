package br.com.bonaldo.backendchallenge.usecases;

import br.com.bonaldo.backendchallenge.domains.OrderItem;
import br.com.bonaldo.backendchallenge.gateways.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilterOrderItems {

    private final OrderGateway orderGateway;

    public List<OrderItem> execute(final LocalDate startDate, final LocalDate finalDate) {
        final List<OrderItem> orders = fetchOrderItemsFromAPI();
        return filterOrderItemsByDate(startDate, finalDate, orders);
    }

    private List<OrderItem> fetchOrderItemsFromAPI() {
        return orderGateway
                .getOrderItems()
                .stream()
                .map(OrderItem::new)
                .collect(Collectors.toList());
    }

    private List<OrderItem> filterOrderItemsByDate(final LocalDate startDate, final LocalDate finalDate, final List<OrderItem> orders) {
        return orders
                .stream()
                .filter(orderItem -> orderItem.getDate().isAfter(startDate.atStartOfDay()))
                .filter(orderItem -> orderItem.getDate().isBefore(finalDate.atTime(LocalTime.MAX)))
                .collect(Collectors.toList());
    }
}