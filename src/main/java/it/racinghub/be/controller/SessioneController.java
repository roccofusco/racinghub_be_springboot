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

import it.racinghub.be.entity.Sessione;
import it.racinghub.be.service.SessioneService;

@RestController
public class SessioneController {

    @Autowired
    private SessioneService sessioneService;

    @GetMapping("/sessions/{idEvento}/event")
    public ResponseEntity<List<Sessione>> getSessionByIdEvento(@PathVariable("idEvento") String idEvento) {
        return new ResponseEntity<List<Sessione>>(sessioneService.getSessionByIdEvento(idEvento),HttpStatus.OK);
    }
    
    @GetMapping("/sessions/{idSessione}")
    public ResponseEntity<Sessione> getSessionById(@PathVariable("idSessione") String idSessione) {
        return new ResponseEntity<Sessione>(sessioneService.getSessionById(idSessione),HttpStatus.OK);
    }
       
    @PostMapping("/save-update/sessions")
    public ResponseEntity<Sessione> saveOrUpdatePilota(@RequestBody Sessione sessione) {
        return new ResponseEntity<Sessione>(sessioneService.saveOrUpdate(sessione),HttpStatus.OK);
    }
    
}
