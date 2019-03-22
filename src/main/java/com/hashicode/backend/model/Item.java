package com.hashicode.backend.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * POJO que representa um json de item
 *
 * @author takahashi
 */
public class Item implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(code, item.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code);
    }
}
