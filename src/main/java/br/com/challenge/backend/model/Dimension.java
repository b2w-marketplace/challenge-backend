package br.com.challenge.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dimension {
    private Float weight;
    private Float height;
    private Float width;
    private Float length;
}
