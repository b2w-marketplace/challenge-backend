package com.hashicode.backend.model;

import java.io.Serializable;

/**
 * POJO que representa as dimensões de um item.
 *
 * @author takahashi
 */
public class Dimension implements Serializable {

    private Float weight;
    private Float height;
    private Float width;
    private Float length;

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }
}
