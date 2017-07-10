package pl.edu.pw.ee.kantor.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CURRENCY")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "VALUE", nullable = false)
    private double value;
    // BigDecimal

    public Currency() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
