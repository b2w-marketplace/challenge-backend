/**
 * Projeto Challenge Backend
 *
 * @author <a href="mailto:leandrorcom@gmail.com">Leandro Rodrigues Combinato</a>
 */
package com.sistema.mvc.entity;

/*
 * Entity Produto  
 */

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sistema.mvc.util.LocalDateDeserializer;
import com.sistema.mvc.util.LocalDateSerializer;

public class Produto {

	private Long code; 
	private String name; 
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)	
	private LocalDate date;
	private Dimensoes dimension;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Dimensoes getDimension() {
		return dimension;
	}

	public void setDimension(Dimensoes dimension) {
		this.dimension = dimension;
	}
}