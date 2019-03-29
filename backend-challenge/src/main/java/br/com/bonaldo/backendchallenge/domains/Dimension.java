package br.com.bonaldo.backendchallenge.domains;

import br.com.bonaldo.backendchallenge.gateways.http.json.DimensionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Dimension {
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal length;

    public Dimension(final DimensionResponse dimensionResponse) {
        this.weight = dimensionResponse.getWeight();
        this.height = dimensionResponse.getHeight();
        this.length = dimensionResponse.getLength();
        this.width = dimensionResponse.getWidth();
    }
}