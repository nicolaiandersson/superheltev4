package com.example.superheltev4.repository;

import com.example.superheltev4.model.Superhelt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SuperheltRepository {

    Superhelt superhelt1 = new Superhelt("Bruce Wayne", "Batman", 1998, "Rig", true, 2.1);
    Superhelt superhelt2 = new Superhelt("Clark Kent", "Superman", 1975, "Flyve", true, 3.8);
    Superhelt superhelt5 = new Superhelt("Clark Kent", "Superman", 1975, "Flyve", true, 3.8);
    Superhelt superhelt3 = new Superhelt("Prinsesse Diana", "Wonder Woman", 1941, "Flyve", true, 3.1);
    Superhelt superhelt4 = new Superhelt("Peter Parker", "Spiderman", 1938, "Spinne", true, 2.1);
    private List<Superhelt> superhelte = new ArrayList<>(Arrays.asList(superhelt1,superhelt2,superhelt3,superhelt4,superhelt5));

    public List<Superhelt> getSuperhelte() {
        return superhelte;
    }

    public Superhelt createSuperHero(String realName, String heroName,
                                     int creationYear, String superPower, boolean isHuman, double power) {
        Superhelt newSuperHero = new Superhelt(realName, heroName, creationYear, superPower, isHuman, power);
        superhelte.add(newSuperHero);

        return newSuperHero;
    }

    public List<Superhelt> searchForSuperhero(String searchTerm) {
        List<Superhelt> searchResults = new ArrayList<>(); // creating arraylist of superheroes

        // Loop through arraylist of superheroes, return if matching searchTerm
        for (Superhelt superhelt : superhelte) {
            String name = superhelt.getHeroName().toLowerCase(); // making all characters in superhero name lower case
            if (name.contains(searchTerm.toLowerCase().trim())) { // if superhero contains searchTerm, add superhero to arraylist
                searchResults.add(superhelt);
            }
        }
        // return searchResult
        return searchResults;
    }

    public List<Superhelt> deleteSuperhero(String searchTerm) {
        List<Superhelt> searchResults = new ArrayList<>();

        searchResults = searchForSuperhero(searchTerm);

        for (Superhelt superhelt : searchResults){
            getSuperhelte().remove(superhelt); // takes  the ArrayList of superheroes and removing the appropriate superhero
        }

        return searchResults;
    }

    public Superhelt editSuperhero(Superhelt superhelt){
        for (Superhelt superheltOb : superhelte){
            if (superheltOb.getHeroName().equalsIgnoreCase(superhelt.getHeroName().toLowerCase())){

                String newHeroName = superhelt.getHeroName();
                superheltOb.setHeroName(newHeroName);

                String newRealName = superhelt.getRealName();
                superheltOb.setRealName(newRealName);

                int newCreationYear = superhelt.getCreationYear();
                superheltOb.setCreationYear(String.valueOf(newCreationYear));

                String newSuperPower = superhelt.getSuperPower();
                superheltOb.setSuperPower(newSuperPower);

                boolean newHuman = superhelt.isHuman();
                superheltOb.setHuman(newHuman);

                double newPower = superhelt.getPower();
                superheltOb.setPower(String.valueOf(newPower));
            }
            return superheltOb;
        }

        return superhelt;
    }
}
