package com.example.superheltev4.repository;

import com.example.superheltev4.dto.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("Repository_Stub")
public class Repository_Stub implements IRepository {

    List<HeroDTO> heroes = new ArrayList<>();
    List<HeroSuperPowerDTO> superpowers = new ArrayList<>();
    List<HeroCityDTO> heroCityDTOS = new ArrayList<>();

    public void testData() {
        heroes.add(new HeroDTO(1, "Bruce Wayne", "Batman", 1939));
        heroes.add(new HeroDTO(2, "Clark Kent", "Superman", 1938));

        superpowers.add(new HeroSuperPowerDTO("Batman", "Bruce Wayne", "Laser, Money, Gadgets"));
        superpowers.add(new HeroSuperPowerDTO("Superman", "Clark Kent", "Laser"));

        heroCityDTOS.add(new HeroCityDTO("Batman", "Gotham City"));
        heroCityDTOS.add(new HeroCityDTO("Superman", "Metropolis"));
    }

    public Repository_Stub() {
        testData();
    }

    @Override
    public List<HeroDTO> getHeroes() {
        List<HeroDTO> results = new ArrayList<>();
        for (HeroDTO hero : heroes) {
            results.add(new HeroDTO(hero.getId(), hero.getRealName(), hero.getRealName(), hero.getCreationYear()));
        }
        return results;
    }

    @Override
    public List<HeroDTO> getSuperHero(String heroSearch) {
        List<HeroDTO> results = new ArrayList<>();
        for (HeroDTO hero : heroes) {
            String name = hero.getHeroName().toLowerCase();
            if (name.contains(hero.getHeroName().toLowerCase().trim())) {
                results.add(new HeroDTO(hero.getId(),hero.getHeroName(), hero.getRealName(), hero.getCreationYear()));
            }
        }
        return results;
    }


    @Override
    public List<HeroPowerCountDTO> countHeroPowers(String heroSearch) {
        return null;
    }

    @Override
    public List<HeroSuperPowerDTO> getHeroPowers(String heroSearch) {
        List<HeroSuperPowerDTO> results = new ArrayList<>();
        for (HeroSuperPowerDTO superpower : superpowers) {
            results.add(new HeroSuperPowerDTO(superpower.getHeroName(),superpower.getRealName(),superpower.getSuperPowers()));
        }
        return results;
    }

    @Override
    public List<HeroCityDTO> getHeroesCities() {
        List<HeroCityDTO> results = new ArrayList<>();
        for (HeroCityDTO heroCity : results) {
            results.add(new HeroCityDTO(heroCity.getHeroes(), heroCity.getCityName()));
        }
        return results;
    }
}
