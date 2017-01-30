package br.com.munieri.view.endpoint;

import br.com.munieri.domain.item.Item;
import br.com.munieri.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

public class ItemDTO {

    private String name;
    private String code;
    private String date;
    private DimensionDTO dimension;

    public ItemDTO() {
    }

    public ItemDTO(Item item) {
        this.name = item.name();
        this.code = item.code().toString();
        this.date = DateUtil.format(item.date());
        this.dimension = new DimensionDTO(item.dimension().weight(),
                item.dimension().height(),
                item.dimension().width(),
                item.dimension().length());
    }

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

    public DimensionDTO getDimension() {
        return dimension;
    }

    public void setDimension(DimensionDTO dimension) {
        this.dimension = dimension;
    }
}
