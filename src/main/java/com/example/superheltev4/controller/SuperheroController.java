package com.example.superheltev4.controller;

import com.example.superheltev4.dto.HeroDTO;
import com.example.superheltev4.model.Superhero;
import com.example.superheltev4.services.Service;
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

     private final Service service;

     public SuperheroController(Service service) {
         this.service = service;
     }


    @GetMapping(path = "superheroes")
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List<Superhero> superheroesList = service.getHeroes();
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<List<Superhero>> getSuperHero(@PathVariable("name") String name){
        List<Superhero> searchResults = service.getSuperHero(name);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

}