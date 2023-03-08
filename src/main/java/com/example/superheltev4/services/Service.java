package com.example.superheltev4.services;
import com.example.superheltev4.dto.HeroDTO;
import com.example.superheltev4.model.Superhero;
import com.example.superheltev4.repository.Repository_DB;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final Repository_DB repository;

    public Service(Repository_DB repository) {
        this.repository = repository;
    }

    public List<Superhero> getHeroes() {
        return repository.getHeroes();
    }

    public List<Superhero> getSuperHero(String searchString) {
        List<Superhero> searchList = new ArrayList<>();
        List<Superhero> superheroes = repository.getSuperhero(searchString);
        for (Superhero hero : superheroes) {
            searchList.add(new Superhero(hero.getId(), hero.getRealName(), hero.getRealName(), hero.getCreationYear(),
                    hero.getSuperpowerID(),hero.getCityID()));
        }
        return searchList;
    }
}
