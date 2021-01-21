package com.kelvincarvalho.challengeb2w.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 7707756723661975529L;

    private String name;

    private String code;

    private LocalDateTime date;

    private DimensionDTO dimension;

}
