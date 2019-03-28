package com.b2w.taskone.web.dto;

import java.time.Instant;

public class ItemDTO {
    String name;
    long code;
    Instant date;
    DimensionDTO dimension;

    public ItemDTO() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Instant getDate() {
        return this.date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public DimensionDTO getDimension() {
        return this.dimension;
    }

    public void setDimension(DimensionDTO dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "{" + " name='" + name + "'" + ", code='" + code + "'" + ", date='" + date + "'" + ", dimension='"
                + dimension + "'" + "}";
    }
}