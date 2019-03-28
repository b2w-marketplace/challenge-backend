package com.b2w.taskone.web.dto;

public class DimensionDTO {

    double weight;
    double height;
    double width;
    double length;

    public DimensionDTO() {

    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double lenght) {
        this.length = lenght;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "{weight= " + weight + ", height= " + height + ", width= " + width + ", lenght= " + length + "}";
    }

}