package kz.kaznitu.lessons.models;

import javax.persistence.*;

@Entity
public class Dress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String title ;
    private String guest;
    private Integer price ;
    private String summary;
    private String brand;


    public Dress() {
    }

    public Dress(String title, String guest, Integer price, String summary, String brand) {
        this.title = title;
        this.guest = guest;
        this.price = price;
        this.summary = summary;
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}