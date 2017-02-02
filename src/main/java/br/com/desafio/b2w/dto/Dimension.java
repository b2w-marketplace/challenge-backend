package br.com.desafio.b2w.dto;

import java.io.Serializable;

public class Dimension implements Serializable {
	
	private static final long serialVersionUID = 4482441269610380313L;

	private Double weight;
	private Double height;
	private Double width;
	private Double length;
	
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
}
