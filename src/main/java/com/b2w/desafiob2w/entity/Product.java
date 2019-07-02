package com.b2w.desafiob2w.entity;
/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence
*/

import java.util.Date;

public class Product {

    //region ATRIBUTOS
    private String name;
    private String code;
    private Date date;
    private Dimension dimension;
    //endregion

    //region CONSTRUTORES
    public Product() {
    }

    public Product(String name, String code, Date date, Dimension dimension) {
        this.name = name;
        this.code = code;
        this.date = date;
        this.dimension = dimension;
    }
    //endregion

    //region GETTERS AND SETTERS

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

    //endregion

    //region TOSTRING

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("name='").append(name).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", date=").append(date);
        sb.append(", dimension=").append(dimension);
        sb.append('}');
        return sb.toString();
    }

    //endregion
}
