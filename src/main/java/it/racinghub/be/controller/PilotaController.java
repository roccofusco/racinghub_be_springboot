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

import it.racinghub.be.entity.Pilota;
import it.racinghub.be.entity.Team;
import it.racinghub.be.service.PilotaService;

@RestController
public class PilotaController {

    @Autowired
    private PilotaService pilotaService;

    @GetMapping("/drivers/{idUtente}/user")
    public ResponseEntity<Pilota> getDriverByIdUtente(@PathVariable("idUtente") String idUtente) {
        return new ResponseEntity<Pilota>(pilotaService.getDriverByIdUtente(idUtente),HttpStatus.OK);
    }
    
    @GetMapping("/drivers/{idTeam}/team")
    public ResponseEntity<List<Pilota>> getDriverByIdTeam(@PathVariable("idTeam") String idTeam) {
        return new ResponseEntity<List<Pilota>>(pilotaService.getDriverByIdTeam(idTeam),HttpStatus.OK);
    }
    
    @GetMapping("/drivers/{idPilota}")
    public ResponseEntity<Pilota> getDriverById(@PathVariable("idPilota") String idPilota) {
        return new ResponseEntity<Pilota>(pilotaService.getDriverById(idPilota),HttpStatus.OK);
    }
    
    @PostMapping("/drivers/save-codriverteam/{idPilota}/{idTeam}")
    public ResponseEntity<Pilota> saveCoDriverTeam(@PathVariable("idPilota") String idPilota, @PathVariable("idTeam") String idTeam) {
        
    	//recupero tutti i piloti del team
    	List<Pilota> listPilota = pilotaService.getDriverByIdTeam(idTeam);
    	
    	//tolgo tutti dal team eccetto il propretario 
    	for(Pilota x : listPilota){
//    		if(!x.getUtente().equals(x.getTeam().getUtente())) {
    		if(!x.getUtente().getTelegramId().equals(x.getTeam().getUtente().getTelegramId())) {
    			x.setTeam(null);
    			pilotaService.saveOrUpdate(x);
    		}
    	}
    	
    	//Setto il team al nuovo pilota
    	Pilota pilota = pilotaService.getDriverById(idPilota);
    	pilota.setTeam(new Team() {{setIdTeam(Integer.parseInt(idTeam)); }});
    	
    	return new ResponseEntity<Pilota>(pilotaService.saveOrUpdate(pilota),HttpStatus.OK);
    }
    
    @PostMapping("/save-update/drivers")
    public ResponseEntity<Pilota> saveOrUpdatePilota(@RequestBody Pilota pilota) {
        return new ResponseEntity<Pilota>(pilotaService.saveOrUpdate(pilota),HttpStatus.OK);
    }
    
}
