package it.racinghub.be.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.racinghub.be.entity.Classifica;
import it.racinghub.be.entity.ClassificaTeam;
import it.racinghub.be.service.ClassificaService;

@RestController
public class ClassificaController {

    @Autowired
    private ClassificaService classificaService;

    @GetMapping("/standings/{idCampionato}/championship/driver")
    public ResponseEntity<List<Classifica>> getStandingsDriverChampionship(@PathVariable("idCampionato") String idCampionato) {
        return new ResponseEntity<List<Classifica>>(classificaService.getClassificaPilotaByCampionato(idCampionato),HttpStatus.OK);
    }
    
    @GetMapping("/standings/{idCampionato}/championship/team")
    public ResponseEntity<List<ClassificaTeam>> getStandingsTeamChampionship(@PathVariable("idCampionato") String idCampionato) {
        return new ResponseEntity<List<ClassificaTeam>>(classificaService.getClassificaTeamByCampionato(idCampionato),HttpStatus.OK);
    }
        
    
}
