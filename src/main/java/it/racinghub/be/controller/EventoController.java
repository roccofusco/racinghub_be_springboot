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

import it.racinghub.be.entity.Evento;
import it.racinghub.be.service.EventoService;

@RestController
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/events/{idCampionato}/championship")
    public ResponseEntity<List<Evento>> getEventByIdCampionato(@PathVariable("idCampionato") String idCampionato) {
        return new ResponseEntity<List<Evento>>(eventoService.getEventByIdCampionato(idCampionato),HttpStatus.OK);
    }
      
    @GetMapping("/events/{idEvento}")
    public ResponseEntity<Evento> getEventById(@PathVariable("idEvento") String idEvento) {
        return new ResponseEntity<Evento>(eventoService.getEventById(idEvento),HttpStatus.OK);
    }
    
    @PostMapping("/save-update/events")
    public ResponseEntity<Evento> saveOrUpdateEvento(@RequestBody Evento evento) {
        return new ResponseEntity<Evento>(eventoService.saveOrUpdate(evento),HttpStatus.OK);
    }
}
