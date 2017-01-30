package br.com.munieri.infrastructure.repository.dimension;

import br.com.munieri.domain.dimension.Dimension;
import br.com.munieri.domain.item.Item;
import br.com.munieri.infrastructure.repository.item.ItemEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "dimension")
public class DimensionEntity implements Dimension {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "item"))
    @Column(name = "ITEM_ID", unique = true, nullable = false)
    private Long id;

    @OneToOne(targetEntity = ItemEntity.class, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Item item;

    @Column(name = "WEIGHT", nullable = false, length = 100)
    private Double weight;

    @Column(name = "HEIGHT", nullable = false, length = 100)
    private Double height;

    @Column(name = "WIDTH", nullable = false, length = 100)
    private Double width;

    @Column(name = "LENGTH", nullable = false, length = 100)
    private Double length;

    public DimensionEntity() {
    }

    public DimensionEntity(Double weight, Double height, Double width, Double length) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public DimensionEntity(Double weight, Double height, Double width, Double length, Item item) {
        this.item = item;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
    }


    @Override
    public Double weight() {
        return this.weight;
    }

    @Override
    public Double height() {
        return this.height;
    }

    @Override
    public Double width() {
        return this.width;
    }

    @Override
    public Double length() {
        return this.length;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
