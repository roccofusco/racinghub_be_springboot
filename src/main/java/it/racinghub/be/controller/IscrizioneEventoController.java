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
import it.racinghub.be.entity.IscrizioneEvento;
import it.racinghub.be.entity.Team;
import it.racinghub.be.service.IscrizioneEventoService;

@RestController
public class IscrizioneEventoController {

    @Autowired
    private IscrizioneEventoService iscrizioneEventoService;

    @GetMapping("/championships/{idPilota}/driver")
    public ResponseEntity<List<Campionato>> getChampionshipByIdUtente(@PathVariable("idPilota") String idUtente) {
        return new ResponseEntity<List<Campionato>>(iscrizioneEventoService.getChampionshipByIdPilotaIscritto(idUtente),HttpStatus.OK);
    }
    
    @GetMapping("/registeredevents/{idEvento}/event")
    public ResponseEntity<List<IscrizioneEvento>> getRegisteredEventsByIdEvento(@PathVariable("idEvento") String idEvento) {
        return new ResponseEntity<List<IscrizioneEvento>>(iscrizioneEventoService.getRegisteredEventsByIdEvento(idEvento),HttpStatus.OK);
    }
    
    @PostMapping("/save-update/registeredevents")
    public ResponseEntity<IscrizioneEvento> saveOrUpdateIscrizioneEvento(@RequestBody IscrizioneEvento iscrizioneEvento) {
        return new ResponseEntity<IscrizioneEvento>(iscrizioneEventoService.saveOrUpdate(iscrizioneEvento),HttpStatus.OK);
    }
        
}
