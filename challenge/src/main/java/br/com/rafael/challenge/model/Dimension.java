package br.com.rafael.challenge.model;

import java.io.Serializable;

public class Dimension {

    private float weight;
    private float height;
    private float width;
    private float length;


    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "weight=" + weight +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
