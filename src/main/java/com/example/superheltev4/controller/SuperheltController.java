package com.example.superheltev4.controller;

import com.example.superheltev4.model.Superhelt;
import com.example.superheltev4.service.SuperheltService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("superhelte")
public class SuperheltController {

    private SuperheltService superheltService;

    public SuperheltController(SuperheltService superheltService){
        this.superheltService = superheltService;
    }

    @RequestMapping("/")
    public ResponseEntity<?> printSuperhelte(@RequestParam(required = false) String format){
        List<Superhelt> superhelte = superheltService.getSuperhelte();

        if(format != null && format.equals("html")){
            StringBuilder html = new StringBuilder();
            html.append("<table>");
            html.append("<tr><th>Superhero Name</th><th>Real Name</th><th>Creation Year</th><th>Superpower</th>" +
                    "<th>Is Human</th><th>Power</th></tr>");
            for (Superhelt superhelt : superhelte){
                html.append("<tr><td>").append(superhelt.getRealName()).append("</td>");
                html.append("<td>").append(superhelt.getHeroName()).append("</td>");
                html.append("<td>").append(superhelt.getCreationYear()).append("</td>");
                html.append("<td>").append(superhelt.getSuperPower()).append("</td>");
                html.append("<td>").append(superhelt.isHuman()).append("</td>");
                html.append("<td>").append(superhelt.getPower()).append("</td></tr>");
            }
            html.append("</table>");

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type", "text/html");
            return new ResponseEntity<>(html.toString(), headers, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(superhelte, HttpStatus.OK);
        }

    }

    @RequestMapping(path = "/{navn}")
    public ResponseEntity<List<Superhelt>> printSpecifikSuperhelt(@PathVariable String navn){
        List<Superhelt> searchResults = superheltService.searchForSuperhero(navn);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @PostMapping(path="/opret")
    public ResponseEntity<Superhelt> opretSuperhelt(@RequestBody Superhelt superhelt){
        Superhelt newSuperhelt = superheltService.createSuperHero(superhelt.getRealName(), superhelt.getHeroName(), superhelt.getCreationYear(),
                superhelt.getSuperPower(), superhelt.isHuman(), superhelt.getPower());
        return new ResponseEntity<Superhelt>(newSuperhelt, HttpStatus.CREATED);
    }

    @PutMapping(path="/ret")
    public ResponseEntity<Superhelt> retSuperhelt(@RequestBody Superhelt superhelt){
        // Edit superhero
        Superhelt retSuperhelt = superheltService.editSuperhero(superhelt);
        return new ResponseEntity<Superhelt>(retSuperhelt, HttpStatus.OK);
    }

    @DeleteMapping(path="/slet/{navn}")
    public ResponseEntity<List<Superhelt>> sletSuperhelt(@PathVariable String navn){
        List<Superhelt> slettetSuperhelt = superheltService.deleteSuperhero(navn);
        return new ResponseEntity<>(slettetSuperhelt, HttpStatus.OK);
    }


}
