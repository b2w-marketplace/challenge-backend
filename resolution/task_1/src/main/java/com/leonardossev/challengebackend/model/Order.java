package com.leonardossev.challengebackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@Builder
public class Order implements Serializable {

    private static final long serialVersionUID = 4732970062046479057L;

    private String name;

    private String code;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime date;

    private Dimension dimension;
}
