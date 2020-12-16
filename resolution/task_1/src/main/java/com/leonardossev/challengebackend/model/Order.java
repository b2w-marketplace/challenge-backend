package com.leonardossev.challengebackend.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class Order implements Serializable {

    private static final long serialVersionUID = 4732970062046479057L;

    private String name;

    private String code;

    private LocalDateTime date;

    private Dimension dimension;
}
