package br.com.bonaldo.backendchallenge.gateways.controllers.json;

import br.com.bonaldo.backendchallenge.domains.OrderItem;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ItemResponse implements Serializable {
    private String name;
    private String code;
    private LocalDateTime date;
    private DimensionResponse dimension;

    public ItemResponse(final OrderItem orderItem) {
        this.name = orderItem.getName();
        this.code = orderItem.getCode();
        this.date = orderItem.getDate();
        this.dimension = new DimensionResponse(orderItem.getDimension());
    }
}
