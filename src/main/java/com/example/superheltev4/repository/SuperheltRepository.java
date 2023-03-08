package com.example.superheltev4.repository;

import com.example.superheltev4.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SuperheltRepository {

    Superhero superhero1 = new Superhero("Bruce Wayne", "Batman", 1998, "Rig",  2.1);
    Superhero superhero2 = new Superhero("Clark Kent", "Superman", 1975, "Flyve", 3.8);
    Superhero superhero5 = new Superhero("Clark Kent", "Superman", 1975, "Flyve", 3.8);
    Superhero superhero3 = new Superhero("Prinsesse Diana", "Wonder Woman", 1941, "Flyve", 3.1);
    Superhero superhero4 = new Superhero("Peter Parker", "Spiderman", 1938, "Spinne", 2.1);
    private List<Superhero> superhelte = new ArrayList<>(Arrays.asList(superhero1, superhero2, superhero3, superhero4, superhero5));

    public List<Superhero> getSuperhelte() {
        return superhelte;
    }

    public Superhero createSuperHero(String realName, String heroName,
                                     int creationYear, String superPower, double power) {
        Superhero newSuperHero = new Superhero(realName, heroName, creationYear, superPower,  power);
        superhelte.add(newSuperHero);

        return newSuperHero;
    }

    public List<Superhero> searchForSuperhero(String searchTerm) {
        List<Superhero> searchResults = new ArrayList<>(); // creating arraylist of superheroes

        // Loop through arraylist of superheroes, return if matching searchTerm
        for (Superhero superhero : superhelte) {
            String name = superhero.getHeroName().toLowerCase(); // making all characters in superhero name lower case
            if (name.contains(searchTerm.toLowerCase().trim())) { // if superhero contains searchTerm, add superhero to arraylist
                searchResults.add(superhero);
            }
        }
        // return searchResult
        return searchResults;
    }

    public List<Superhero> deleteSuperhero(String searchTerm) {
        List<Superhero> searchResults = new ArrayList<>();

        searchResults = searchForSuperhero(searchTerm);

        for (Superhero superhero : searchResults){
            getSuperhelte().remove(superhero); // takes  the ArrayList of superheroes and removing the appropriate superhero
        }

        return searchResults;
    }

    public Superhero editSuperhero(Superhero superhero){
        for (Superhero superheroOb : superhelte){
            if (superheroOb.getHeroName().equalsIgnoreCase(superhero.getHeroName().toLowerCase())){

                String newHeroName = superhero.getHeroName();
                superheroOb.setHeroName(newHeroName);

                String newRealName = superhero.getRealName();
                superheroOb.setRealName(newRealName);

                int newCreationYear = superhero.getCreationYear();
                superheroOb.setCreationYear(String.valueOf(newCreationYear));

                String newSuperPower = superhero.getSuperPower();
                superheroOb.setSuperPower(newSuperPower);

                double newPower = superhero.getPower();
                superheroOb.setPower(String.valueOf(newPower));
            }
            return superheroOb;
        }

        return superhero;
    }
}
