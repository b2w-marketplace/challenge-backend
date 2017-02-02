package br.com.desafio.b2w.dto;

import java.io.Serializable;
import java.util.Calendar;

public class Item implements Serializable {
	
	private static final long serialVersionUID = -7786003414913036293L;

	private String name;
	private String code;
	private Calendar date;
	private Dimension dimension;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public Dimension getDimension() {
		return dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
}
