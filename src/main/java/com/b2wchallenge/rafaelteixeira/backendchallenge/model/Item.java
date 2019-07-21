package com.b2wchallenge.rafaelteixeira.backendchallenge.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
    private String name;
    private int code;
    private Date date;
    private Dimension dimension;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    @Override
    public String toString(){
     return "---Item--- \nName: " + name + "\nCode: " + code + "\nDate :" + date + "\nDimensions: " + dimension.toString();
    }
}

