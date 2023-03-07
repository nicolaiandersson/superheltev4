package com.example.superheltev4.service;

import com.example.superheltev4.model.Superhelt;
import com.example.superheltev4.repository.SuperheltRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperheltService {
    private SuperheltRepository superheltRepository;

    public SuperheltService(SuperheltRepository superheltRepository){
        this.superheltRepository = superheltRepository;
    }

    public List<Superhelt> getSuperhelte(){
        return superheltRepository.getSuperhelte();
    }

    public List<Superhelt> searchForSuperhero(String searchTerm) {
        return superheltRepository.searchForSuperhero(searchTerm);
    }

    public Superhelt createSuperHero(String realName, String heroName,
                                     int creationYear, String superPower, boolean isHuman, double power) {
        return superheltRepository.createSuperHero(realName, heroName, creationYear, superPower, isHuman, power);
    }

    public List<Superhelt> deleteSuperhero(String searchTerm){
        return superheltRepository.deleteSuperhero(searchTerm);
    }

    public Superhelt editSuperhero(Superhelt superhelt){
        Superhelt retSuperhelt = superheltRepository.editSuperhero(superhelt);
        return retSuperhelt;
    }
}
