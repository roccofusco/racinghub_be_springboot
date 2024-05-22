package it.racinghub.be.service;

import java.util.List;

import it.racinghub.be.entity.Campionato;

public interface CampionatoService {

	public List<Campionato> getChampionshipByIdUtente(String idUtente);
	public Campionato getChampionshipById(String idCampionato);
	public Campionato saveOrUpdate(Campionato campionato);

}
