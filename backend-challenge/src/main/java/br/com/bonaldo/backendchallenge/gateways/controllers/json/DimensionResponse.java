package br.com.bonaldo.backendchallenge.gateways.controllers.json;

import br.com.bonaldo.backendchallenge.domains.Dimension;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DimensionResponse implements Serializable {
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal length;

    public DimensionResponse(final Dimension dimension) {
        this.weight = dimension.getWeight();
        this.height = dimension.getHeight();
        this.width = dimension.getWidth();
        this.length = dimension.getLength();
    }
}