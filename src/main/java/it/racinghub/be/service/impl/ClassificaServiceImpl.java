package it.racinghub.be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.Classifica;
import it.racinghub.be.entity.ClassificaTeam;
import it.racinghub.be.repository.ClassificaRepository;
import it.racinghub.be.repository.ClassificaTeamRepository;
import it.racinghub.be.service.ClassificaService;

@Service
public class ClassificaServiceImpl  implements ClassificaService{

    @Autowired
    private ClassificaRepository classificaRepository;
  
    @Autowired
    private ClassificaTeamRepository classificaTeamRepository;

	@Override
	public List<Classifica> getClassificaPilotaByCampionato(String idCampionato) {
		Campionato c = new Campionato() {{setIdCampionato(Integer.parseInt(idCampionato));}};
//		classificaRepository.getClassificaCostruttori(c);
		return classificaRepository.findByCampionatoOrderByPosizione(c);
	}

	@Override
	public List<ClassificaTeam> getClassificaTeamByCampionato(String idCampionato) {
		Campionato c = new Campionato() {{setIdCampionato(Integer.parseInt(idCampionato));}};
//		classificaRepository.getClassificaCostruttori(c);
		return classificaTeamRepository.findByCampionatoOrderByPosizione(c);
	}
}