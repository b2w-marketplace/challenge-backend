package br.com.frsiqueira.challengebackend.dto;

import java.util.Calendar;
import java.util.Optional;

public class Item {

    private String name;
    private String code;
    private Calendar date;
    private Dimension dimension;

    public Item(String name, String code, Calendar date, Dimension dimension) {
        this.name = name;
        this.code = code;
        this.date = date;
        this.dimension = dimension;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Calendar getDate() {
        return date;
    }

    public Optional<Dimension> getDimension() {
        return Optional.of(dimension);
    }
}
