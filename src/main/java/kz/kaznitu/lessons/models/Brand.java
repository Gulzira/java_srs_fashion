package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String name ;
    private String strana ;

    public Brand(){}

    public Brand(String model, String company, String strana) {
        this.name = name;
        this.strana = strana;
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

    public String getStrana() {
        return strana;
    }

    public void setStrana(String strana) {
        this.strana = strana;
    }
}

