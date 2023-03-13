package com.example.superheltev4.dto;

import java.time.LocalDate;

public class HeroDTO {


    private int id;
    private String realName;
    private String heroName;
    private int creationYear;




    public HeroDTO(int id, String realName, String heroName, int creationYear) {
        this.id = id;
        this.realName = realName;
        this.heroName = heroName;
        this.creationYear = creationYear;
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

    public int getCreationYear() {
        return creationYear;
    }

}

