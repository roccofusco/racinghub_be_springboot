package it.racinghub.be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.Utente;
import it.racinghub.be.repository.CampionatoRepository;
import it.racinghub.be.service.CampionatoService;

@Service
public class CampionatoServiceImpl  implements CampionatoService{

    @Autowired
    private CampionatoRepository campionatoRepository;

	@Override
	public List<Campionato> getChampionshipByIdUtente(String idUtente) {
		Utente u = new Utente() {{setIdUtente(Integer.parseInt(idUtente));}};
		
		return campionatoRepository.findByUtente(u);
	}

	@Override
	public Campionato getChampionshipById(String idCampionato) {

		return campionatoRepository.findById(Integer.parseInt(idCampionato)).get();
	}

	@Override
	public Campionato saveOrUpdate(Campionato campionato) {

		campionato.setIdRegolamento(1);
		
		return campionatoRepository.save(campionato);
	}

}