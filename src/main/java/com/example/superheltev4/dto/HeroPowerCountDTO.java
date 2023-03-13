package com.example.superheltev4.dto;

public class HeroPowerCountDTO {
    private String realName;
    private String heroName;
    private int powerCount;

    public HeroPowerCountDTO(String realName, String heroName, int powerCount) {
        this.realName = realName;
        this.heroName = heroName;
        this.powerCount = powerCount;
    }

    public String getRealName() {
        return realName;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getPowerCount() {
        return powerCount;
    }

}
