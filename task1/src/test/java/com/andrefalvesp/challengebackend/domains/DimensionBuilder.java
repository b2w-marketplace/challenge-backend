package com.andrefalvesp.challengebackend.domains;

public class DimensionBuilder {

  public static Dimension DIMENSION_DEFAULT() {
    return Dimension.builder()
        .weight(10.5)
        .length(10.5)
        .height(10.5)
        .width(10.5)
        .build();
  }
}
