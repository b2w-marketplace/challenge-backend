package br.com.bonaldo.backendchallenge.gateways.http.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse implements Serializable {
    private String name;
    private String code;
    private LocalDateTime date;
    private DimensionResponse dimension;
}
