package com.b2wchallenge.rafaelteixeira.backendchallenge.model;

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
    public String toString(){
        return "\nWeight: " + weight + "\nHeight: " + height + "\nWidth :" + width + "\nLength: " + length;
    }
}




