package com.example.demo.controller.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class OrderResultDTO {

private String name;

private String code;

private LocalDate date;

private Dimension dimension;

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

public OrderResultDTO(OrderDTO order) {
	super();
	this.name = order.getName();
	this.code = order.getCode();
	this.date = LocalDate .parse(order.getDate(), formatter);
	this.dimension = order.getDimension();
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

public LocalDate getDate() {
return date;
}

public void setDate(LocalDate date) {
this.date = date;
}

public Dimension getDimension() {
return dimension;
}

public void setDimension(Dimension dimension) {
this.dimension = dimension;
}



}