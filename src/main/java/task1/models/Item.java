package task1.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
    private String name;
    private String code;
    private String date;
    private Dimension dimension;

    public Item(String name, String code, String date, Dimension dimension) {
        this.name = name;
        this.code = code;
        this.date = date;
        this.dimension = dimension;
    }

    public Boolean onValidPeriod(String beginDate, String finalDate) {
        SimpleDateFormat isoInstantFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            String itemDateStr = dateFormat.format(isoInstantFormat.parse(this.getDate()));
            Date itemDate = dateFormat.parse(itemDateStr);

            Date start = dateFormat.parse(beginDate);
            Date end = dateFormat.parse(finalDate);

            return itemDate.compareTo(start) >= 0 && itemDate.compareTo(end) <= 0;
        } catch (ParseException e) {
            return false;
        }
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

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
