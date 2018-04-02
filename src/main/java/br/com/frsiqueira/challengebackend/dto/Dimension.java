package br.com.frsiqueira.challengebackend.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Dimension {

    private float weight;
    private float height;
    private float width;
    private float length;

    public Dimension(float weight, float height, float width, float length) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Dimension() {
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimension dimension = (Dimension) o;
        return Float.compare(dimension.weight, weight) == 0 &&
                Float.compare(dimension.height, height) == 0 &&
                Float.compare(dimension.width, width) == 0 &&
                Float.compare(dimension.length, length) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(weight, height, width, length);
    }
}

