package com.example.superheltev4.dto;

public class HeroSuperPowerDTO {
    private String heroName;
    private String realName;
    private String superPowers;


    public HeroSuperPowerDTO(String heroName, String realName, String superPowers) {
        this.heroName = heroName;
        this.realName = realName;
        this.superPowers = superPowers;

    }


    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }
    public String getSuperPowers() {
        return superPowers;
    }

}
