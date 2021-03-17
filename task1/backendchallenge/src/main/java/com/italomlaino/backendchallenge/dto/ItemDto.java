package com.italomlaino.backendchallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
@Builder
@AllArgsConstructor
public class ItemDto {

    private String name;
    private String code;
    private ZonedDateTime date;
    private DimensionDto dimension;
}
