package com.andrefalvesp.challengebackend.domains;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Order {

  private String name;
  private String code;
  private LocalDate date;
  private Dimension dimension;

}
