package com.example.demo.controller.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDTO {

private String name;

private String code;

private String date;

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

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public Dimension getDimension() {
return dimension;
}

public void setDimension(Dimension dimension) {
this.dimension = dimension;
}

}