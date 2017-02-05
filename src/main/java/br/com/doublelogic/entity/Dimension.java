package br.com.doublelogic.entity;

/**
 * 
 * Class to represent the dimensons of a product
 * 
 * @author diego
 *
 */
public class Dimension {

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