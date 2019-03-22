package com.rafaelfelix.b2wchallenge.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ProductDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long code; 
	private String name;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private LocalDateTime date;
	
	private DimensionsDTO dimensions;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Long code, String name, LocalDateTime date, DimensionsDTO dimensions) {
		this.code = code;
		this.name = name;
		this.date = date;
		this.dimensions = dimensions;
	}

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}
	
	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}
	
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	/**
	 * @return the dimensions
	 */
	public DimensionsDTO getDimensions() {
		return dimensions;
	}
	
	/**
	 * @param dimensions the dimensions to set
	 */
	public void setDimension(DimensionsDTO dimensions) {
		this.dimensions = dimensions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(code, other.code);
	}

}
