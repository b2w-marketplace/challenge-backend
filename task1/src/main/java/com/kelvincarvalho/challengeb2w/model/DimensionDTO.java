package com.kelvincarvalho.challengeb2w.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class DimensionDTO implements Serializable {

    private static final long serialVersionUID = 2999528709922788484L;

    private double weight;

    private double height;

    private double width;

    private double length;

}
