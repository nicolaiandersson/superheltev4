package com.example.superheltev4.services;

import com.example.superheltev4.dto.HeroDTO;
import com.example.superheltev4.repository.Repository_DB;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final Repository_DB repository;

    public Service(Repository_DB repository) {
        this.repository = repository;
    }

    public List<HeroDTO> getHeroes() {
        List<HeroDTO> results = new ArrayList<>();
        List<HeroDTO> superheroes = repository.getHeroes();
        for (HeroDTO hero : superheroes) {
            results.add(new HeroDTO(hero.getId(), hero.getRealName(), hero.getRealName(), hero.getCreationYear()));
        }
        return results;
    }


    public List<HeroDTO> getSuperHero(String heroSearch) {
        List<HeroDTO> results = new ArrayList<>();
        List<HeroDTO> superheroes = repository.getSuperhero(heroSearch);
        for (HeroDTO hero : superheroes) {
            results.add(new HeroDTO(hero.getId(), hero.getRealName(), hero.getRealName(), hero.getCreationYear()));
        }
        return results;
    }
}
