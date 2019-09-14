package br.com.himewen.task1.models;


public class Item {
    private String code;
    private String name;
    private String date;
    private Dimension dimension;

    public Item() {
        this.code = "0";
        this.name = "";
        this.date = "";
        this.dimension = null;
    }

    public Item(String code, String name, String date, Dimension dimension) {
        this.code = code;
        this.name = name;
        this.date = "";
        this.dimension = dimension;
    }

    /**
     * @return int return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return LocalDateTime return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return Dimension return the dimension
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * @param dimension the dimension to set
     */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

}