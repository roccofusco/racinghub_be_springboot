package it.racinghub.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.service.CampionatoService;

@RestController
public class CampionatoController {

    @Autowired
    private CampionatoService campionatoService;

    @GetMapping("/championships/{idUtente}/user")
    public ResponseEntity<List<Campionato>> getChampionshipByIdUtente(@PathVariable("idUtente") String idUtente) {
        return new ResponseEntity<List<Campionato>>(campionatoService.getChampionshipByIdUtente(idUtente),HttpStatus.OK);
    }
    
    @GetMapping("/championships/{idCampionato}")
    public ResponseEntity<Campionato> getChampionshipById(@PathVariable("idCampionato") String idCampionato) {
        return new ResponseEntity<Campionato>(campionatoService.getChampionshipById(idCampionato),HttpStatus.OK);
    }
        
    @PostMapping("/save-update/championships")
    public ResponseEntity<Campionato> saveOrUpdateCampionato(@RequestBody Campionato campionato) {
        return new ResponseEntity<Campionato>(campionatoService.saveOrUpdate(campionato),HttpStatus.OK);
    }
    
}
