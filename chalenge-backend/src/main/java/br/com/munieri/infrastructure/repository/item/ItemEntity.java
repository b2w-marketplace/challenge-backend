package br.com.munieri.infrastructure.repository.item;

import br.com.munieri.domain.dimension.Dimension;
import br.com.munieri.domain.item.Item;
import br.com.munieri.infrastructure.repository.dimension.DimensionEntity;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;

@Entity
@Table(name = "item")
public class ItemEntity implements Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ITEM_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "CODE", nullable = false, length = 100)
    private Long code;

    @Column(name = "DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = DimensionEntity.class,
            mappedBy = "item", cascade = CascadeType.ALL)
    @JoinColumn(name="DIMENSION_ID")
    private Dimension dimension;

    public ItemEntity() {
    }

    public ItemEntity(String name, Long code, Date date) {
        this.name = name;
        this.code = code;
        this.date = date;
    }

    public ItemEntity(String name, Long code, Date date, Dimension dimension) {
        this.name = name;
        this.code = code;
        this.date = date;
        this.dimension = dimension;
    }

    @Override
    public Long id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Long code() {
        return this.code;
    }

    @Override
    public Date date() {
        return this.date;
    }

    @Override
    public Dimension dimension() {
        return this.dimension;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
