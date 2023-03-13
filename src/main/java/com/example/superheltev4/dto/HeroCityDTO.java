package com.example.superheltev4.dto;

import java.time.LocalDate;

public class HeroCityDTO {
    private String heroes;
    private String cityName;

    public HeroCityDTO(String heroes, String cityName) {
        this.heroes = heroes;
        this.cityName = cityName;
    }

    public String getHeroes() {
        return heroes;
    }

    public String getCityName() {
        return cityName;
    }
}
