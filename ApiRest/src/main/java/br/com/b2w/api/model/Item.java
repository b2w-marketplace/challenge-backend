package br.com.b2w.api.model;

import java.io.Serializable;
import java.util.Date;

public class Item  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8697871639034251804L;
	
	private String name;
	private String code;
	private Date date;
	private Dimension dimension;
	
	public Item() {
	}

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
