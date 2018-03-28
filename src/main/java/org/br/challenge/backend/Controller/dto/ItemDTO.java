package org.br.challenge.backend.Controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {

  private String name;
  private String code;
  private Date date;
  private DimensionDTO dimension;
}
