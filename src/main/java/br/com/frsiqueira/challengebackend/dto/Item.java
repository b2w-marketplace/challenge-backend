package br.com.frsiqueira.challengebackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.logging.log4j.LogManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("Item");

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

    public Item(){ }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Calendar getDate() {
        return date;
    }

    public Dimension getDimension() {
        return dimension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(code, item.code) &&
                Objects.equals(date, item.date) &&
                Objects.equals(dimension, item.dimension);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, code, date, dimension);
    }
}
