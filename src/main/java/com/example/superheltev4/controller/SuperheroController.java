package com.example.superheltev4.controller;

import com.example.superheltev4.model.Superhero;
import com.example.superheltev4.service.SuperheltService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {

    private final SuperheltService service;

    public SuperheroController(SuperheltService service) {
        this.service = service;
    }

    @GetMapping(path = "superheroes")     //localhost:8082/kea/superheroes
    public ResponseEntity<List<Superhero>> getSuperheroes() {
        List<Superhero> superheroesList = service.getSuperhelte();
        return new ResponseEntity<>(superheroesList, HttpStatus.OK);
    }
}