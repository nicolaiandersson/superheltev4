package com.example.superheltev4.dto;

import java.time.LocalDate;

public class HeroCityDTO {
    private int id;
    private String heroName;
    private String city;
    private LocalDate creationDate;

    public HeroCityDTO(int id, String heroName, String city, LocalDate creationDate) {
        this.id = id;
        this.heroName = heroName;
        this.city = city;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
