package com.example.superheltev4.controller;

import com.example.superheltev4.dto.HeroCityDTO;
import com.example.superheltev4.dto.HeroDTO;
import com.example.superheltev4.dto.HeroPowerCountDTO;
import com.example.superheltev4.dto.HeroSuperPowerDTO;
import com.example.superheltev4.model.Superhero;
import com.example.superheltev4.repository.IRepository;
import com.example.superheltev4.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {

     IRepository repository;

     @Autowired
     public SuperheroController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl){
         repository = (IRepository) context.getBean(impl);
     }


    @GetMapping(path = "")
    public ResponseEntity<List<HeroDTO>> getSuperheroes() {
        List<HeroDTO> superheroesList = repository.getHeroes();
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<List<HeroDTO>> getSuperHero(@PathVariable("name") String heroName){
        List<HeroDTO> superheroes = repository.getSuperHero(heroName);
        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }

    @GetMapping(path = "/powercount/{name}")
    public ResponseEntity<List<HeroPowerCountDTO>> countHeroPowers(@PathVariable("name") String heroName){
        List<HeroPowerCountDTO> countPower = repository.countHeroPowers(heroName);
        return new ResponseEntity<>(countPower, HttpStatus.OK);
    }

    @GetMapping(path = "superpowers/{name}")
    public ResponseEntity<List<HeroSuperPowerDTO>> heroPowers(@PathVariable String heroName) {
        List<HeroSuperPowerDTO> heroPowers = repository.getHeroPowers(heroName);
        return new ResponseEntity<>(heroPowers, HttpStatus.OK);
    }

    @GetMapping("/city")
    public ResponseEntity<List<HeroCityDTO>> getCityByHeroName() {
        List<HeroCityDTO> heroesAndCities = repository.getHeroesCities();
        return new ResponseEntity<>(heroesAndCities, HttpStatus.OK);
    }

}