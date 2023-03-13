package com.example.superheltev4.repository;

import com.example.superheltev4.dto.*;
import com.example.superheltev4.model.Superhero;

import java.util.List;
public interface IRepository {

    public List<HeroDTO> getHeroes();
    public List<HeroDTO> getSuperHero(String heroSearch);

    public List<HeroPowerCountDTO> countHeroPowers(String heroSearch);

    public List<HeroSuperPowerDTO> getHeroPowers(String heroSearch);

    public List<HeroCityDTO> getHeroesCities();
}
