package br.com.b2w.api.model;

import java.io.Serializable;

public class Dimension implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7019958542858763343L;
	
	private double weight;
	private double height;
	private double width;
	private double length;
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}	
}
