package com.rafaelfelix.b2wchallenge.dto;

import java.io.Serializable;

public class DimensionsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double weight;
	private Double height;
	private Double width;
	private Double length;
	
	public DimensionsDTO () {
		
	}

	public DimensionsDTO(Double weight, Double height, Double width, Double length) {
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
	}

	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public Double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Double length) {
		this.length = length;
	}

}
