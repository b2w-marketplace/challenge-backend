package br.com.bonaldo.backendchallenge.domains;

import br.com.bonaldo.backendchallenge.gateways.http.json.OrderItemResponse;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderItem {
    private String name;
    private String code;
    private LocalDateTime date;
    private Dimension dimension;

    public OrderItem(final OrderItemResponse orderItemResponse) {
        this.name = orderItemResponse.getName();
        this.code = orderItemResponse.getCode();
        this.date = orderItemResponse.getDate();
        this.dimension = new Dimension(orderItemResponse.getDimension());
    }
}
