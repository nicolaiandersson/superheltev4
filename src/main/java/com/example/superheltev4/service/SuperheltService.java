package com.example.superheltev4.service;

import com.example.superheltev4.model.Superhero;
import com.example.superheltev4.repository.Repository_DB;
import com.example.superheltev4.repository.SuperheltRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheltService {

    private SuperheltRepository superheltRepository;
    Repository_DB myRepositoryDB;

    public void MyService(Repository_DB myRepositorydb) {
        this.myRepositoryDB = myRepositorydb;
    }


    public SuperheltService(SuperheltRepository superheltRepository){
        this.superheltRepository = superheltRepository;
    }

    public List<Superhero> getSuperhelte(){
        return superheltRepository.getSuperhelte();
    }

    public List<Superhero> searchForSuperhero(String searchTerm) {
        return superheltRepository.searchForSuperhero(searchTerm);
    }

    public Superhero createSuperHero(String realName, String heroName,
                                     int creationYear, String superPower, double power) {
        return superheltRepository.createSuperHero(realName, heroName, creationYear, superPower, power);
    }

    public List<Superhero> deleteSuperhero(String searchTerm){
        return superheltRepository.deleteSuperhero(searchTerm);
    }

    public Superhero editSuperhero(Superhero superhero){
        Superhero retSuperhero = superheltRepository.editSuperhero(superhero);
        return retSuperhero;
    }
}
