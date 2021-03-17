package com.italomlaino.backendchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class DimensionDto {

    private double weight;
    private double height;
    private double width;
    private double length;
}
