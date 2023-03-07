package com.example.superheltev4.dto;

import java.time.LocalDate;

public class HeroDTO {
    private int id;
    private String realName;
    private String heroName;
    private LocalDate creationDate;
    private boolean isHuman;
    private double power;

    public HeroDTO(int id, String realName, String heroName, LocalDate creationDate, boolean isHuman, double power) {
        this.id = id;
        this.realName = realName;
        this.heroName = heroName;
        this.creationDate = creationDate;
        this.isHuman = isHuman;
        this.power = power;
    }

    public int getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }

    public String getHeroName() {
        return heroName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public double getPower() {
        return power;
    }
}

