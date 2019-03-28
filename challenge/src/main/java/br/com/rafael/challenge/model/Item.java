package br.com.rafael.challenge.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

public class Item {

    private String name;
    private String code;
    @DateTimeFormat
    private LocalDateTime date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", dimension=" + dimension +
                '}';
    }
}
