package com.example.superheltev4.model;

public class Superhero {

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

    public int getSuperpowerID() {
        return superpowerID;
    }

    public String getCityID() {
        return cityID;
    }

    // attributes
    private int id;
    private String realName;
    private String heroName;
    private int creationYear;
    private int superpowerID;
    private String cityID;


    // constructor
    public Superhero(int id, String realName, String heroName, int creationYear, int superpowerID, String cityID) {
        this.id = id;
        this.realName = realName;
        this.heroName = heroName;
        this.creationYear = creationYear;
        this.superpowerID = superpowerID;
        this.cityID = cityID;
    }

}
