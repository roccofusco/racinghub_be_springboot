package it.racinghub.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.racinghub.be.entity.Utente;
import it.racinghub.be.service.UtenteService;

@RestController
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping("/save-update/users")
    public ResponseEntity<Utente> saveOrUpdateUtente(@RequestBody Utente utente) {
        return new ResponseEntity<Utente>(utenteService.saveOrUpdate(utente), HttpStatus.OK);
    }
}
