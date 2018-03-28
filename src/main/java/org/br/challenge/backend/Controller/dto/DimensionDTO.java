package org.br.challenge.backend.Controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DimensionDTO {
  private Double weight;
  private Double height;
  private Double width;
  private Double length;
}
