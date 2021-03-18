package com.andrefalvesp.challengebackend.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Dimension {

  private double weight;
  private double height;
  private double width;
  private double length;

}