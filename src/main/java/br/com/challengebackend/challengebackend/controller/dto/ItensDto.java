package br.com.challengebackend.challengebackend.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.challengebackend.challengebackend.modelo.Dimension;
import br.com.challengebackend.challengebackend.modelo.Itens;

public class ItensDto {
	
	private String name; 
    private Long code; 
    private LocalDateTime date;
    private Dimension dimension;
	
    public Dimension getDimension() {
		return dimension;
	}

	public ItensDto(Itens itens) {
    	this.name = itens.getName();
    	this.code = itens.getCode();
    	this.date = itens.getDate();
    	this.dimension = itens.getDimension();
    }
    
    public String getName() {
		return name;
	}
	public Long getCode() {
		return code;
	}
	public LocalDateTime getDate() {
		return date;
	}

	public static List<ItensDto> converter(List<Itens> itens) {
		return itens.stream().map(ItensDto::new).collect(Collectors.toList());
	}
}
