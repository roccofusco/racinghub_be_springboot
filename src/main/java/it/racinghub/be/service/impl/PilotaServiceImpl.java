package it.racinghub.be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.racinghub.be.entity.Pilota;
import it.racinghub.be.entity.Team;
import it.racinghub.be.entity.Utente;
import it.racinghub.be.repository.PilotaRepository;
import it.racinghub.be.service.PilotaService;

@Service
public class PilotaServiceImpl  implements PilotaService{

    @Autowired
    private PilotaRepository pilotaRepository;

	@Override
	public Pilota getDriverByIdUtente(String idUtente) {
		Utente u = new Utente() {{setIdUtente(Integer.parseInt(idUtente));}};
		
		return pilotaRepository.findByUtente(u);
	}

	@Override
	public List<Pilota> getDriverByIdTeam(String idTeam) {
		Team u = new Team() {{setIdTeam(Integer.parseInt(idTeam));}};
		
		return pilotaRepository.findByTeam(u);
	}
	
	@Override
	public Pilota getDriverById(String idPilota) {
		
		return pilotaRepository.findById(Integer.parseInt(idPilota)).get();
	}
	
	@Override
	public Pilota saveOrUpdate(Pilota pilota) {
//		Pilota existingPilota = pilotaRepository.findByUtente(pilota.getUtente());
//        if (Objects.nonNull(existingPilota)) {
//        	existingPilota.setNome(pilota.getNome());
//        	existingPilota.setCognome(pilota.getCognome());
//        	existingPilota.setDataNascita(pilota.getDataNascita());
//        	existingPilota.setPesoKg(pilota.getPesoKg());
//        	existingPilota.setCellulare(pilota.getCellulare());
//            return pilotaRepository.save(existingPilota);
//        }
        return pilotaRepository.save(pilota);
	}

	@Override
	public Pilota updateCoDriverTeam(String idPilota, String idTeam) {
		// TODO Auto-generated method stub
		return null;
	}

}