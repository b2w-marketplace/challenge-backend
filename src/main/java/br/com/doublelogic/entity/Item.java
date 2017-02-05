package br.com.doublelogic.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * 
 * Class to represent one product
 * 
 * @author diego
 *
 */
public class Item {

	private long code;

	private String name;
	
	@JsonFormat(shape=Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date date;
	
	private Dimension dimension;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
}