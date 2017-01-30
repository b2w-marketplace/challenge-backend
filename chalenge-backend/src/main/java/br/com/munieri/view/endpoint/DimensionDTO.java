package br.com.munieri.view.endpoint;

public class DimensionDTO {

    private String weight;
    private String height;
    private String width;
    private String length;

    public DimensionDTO() {
    }

    public DimensionDTO(Double weight, Double height, Double width, Double length) {
        this.weight = weight.toString();
        this.height = height.toString();
        this.width = width.toString();
        this.length = length.toString();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
