package it.racinghub.be.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import it.racinghub.be.entity.Risultato;
import it.racinghub.be.service.RisultatoService;

@RestController
public class RisultatoController {

    @Autowired
    private RisultatoService risultatoService;

    @PostMapping("/results/{idSessione}/session/file")
    public ResponseEntity<HashMap> saveRisultatoFromFile(@RequestPart("file") MultipartFile file, @RequestPart("fileName") String fileName, @PathVariable("idSessione") int idSessione) {
    	
    	if (risultatoService.verifyFile(file, fileName)) {
    		
    		//prepareListRisultato
    		List<Risultato> listRisultato = risultatoService.getListRisultatoFromFile(file, fileName, idSessione);
    		
    		//deleteAllRisultatoBySessione
    		risultatoService.cancellaRisultatiBySessione(idSessione);
    		
    		//saveAllRisultato
    		risultatoService.importaRisultato(listRisultato, idSessione);

    		HashMap<String, List<Risultato>> res = new HashMap<String, List<Risultato>>();
    		res.put("data",listRisultato);
    		return ResponseEntity.ok().body(res);
        } else {
        	
        	HashMap<String, String> res = new HashMap<String, String>();
        	res.put("errorDesc", "Il file non contiene tutte le colonne minime o la formattazione non è corretta.");
        	
            return ResponseEntity.badRequest().body(res);
        }
    }
}
