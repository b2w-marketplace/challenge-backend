package com.b2w.desafiob2w.entity;
/*
    Tiago Iwamoto
    tiago.iwamoto@gmail.com
    System Analyst
    MBA Business Intelligence
*/

public class Dimension {

    //region ATRIBUTOS
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    //endregion

    //region CONSTRUTORES

    public Dimension() {
    }

    public Dimension(Double weight, Double height, Double width, Double length) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    //endregion

    //region GETTERS AND SETTERS

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    //endregion

    //region TOSTRING

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dimension{");
        sb.append("weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append(", width=").append(width);
        sb.append(", length=").append(length);
        sb.append('}');
        return sb.toString();
    }

    //endregion

}
