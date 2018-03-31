package br.com.challenge.backend.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    private String name;
    private Integer code;
    private LocalDateTime date;
    private Dimension dimension;

}


