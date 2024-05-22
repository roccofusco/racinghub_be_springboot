package it.racinghub.be.service;

import java.util.List;

import it.racinghub.be.entity.Classifica;
import it.racinghub.be.entity.ClassificaTeam;

public interface ClassificaService {

	public List<Classifica> getClassificaPilotaByCampionato(String idCampionato);
	
	public List<ClassificaTeam> getClassificaTeamByCampionato(String idCampionato);

}
