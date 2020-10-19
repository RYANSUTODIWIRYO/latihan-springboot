package com.latihan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity // This tells Hibernate to make a table out of this class
public class Product {

    @Id // This makes JPA recognizes it as the object's ID
    @GeneratedValue(strategy = GenerationType.AUTO) // This makes the ID should be generated automatically
    private Long id;
    private String name;
    private BigDecimal price;

    // This constructor exists only for the sake of JPA.
    // You do not use it directly, so it is designated as protected
    protected Product() {}

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
