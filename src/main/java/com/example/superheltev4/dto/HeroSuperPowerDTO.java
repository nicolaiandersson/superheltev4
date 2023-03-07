package com.example.superheltev4.dto;

import java.time.LocalDate;

public class HeroSuperPowerDTO {
    private int id;
    private String heroName;
    private String superPower;
    private LocalDate creationDate;

    public HeroSuperPowerDTO(int id, String heroName, String superPower, LocalDate creationDate) {
        this.id = id;
        this.heroName = heroName;
        this.superPower = superPower;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

}
