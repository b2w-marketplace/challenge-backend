package com.b2w.challengebackend.modelo;

import java.time.Instant;
import java.time.LocalDateTime;

public class Item {
	
    String name;
    long code;
    Instant date;
    Dimension dimension;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public Dimension getDimension() {
		return dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

}
