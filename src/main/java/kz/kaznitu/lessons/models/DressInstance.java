package kz.kaznitu.lessons.models;

import javax.persistence.*;

@Entity
public class DressInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String model ;
    private Integer size ;
    private String brand;

    public DressInstance(){}

    public DressInstance(String model, Integer size, String brand) {
        this.model = model;
        this.size = size;
        this.brand= brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand= brand;
    }
}
