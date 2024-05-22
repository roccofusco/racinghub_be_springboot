package it.racinghub.be.service;

import java.util.List;

import it.racinghub.be.entity.Evento;

public interface EventoService {

	public List<Evento> getEventByIdCampionato(String idCampionato);
	public Evento getEventById(String idEvento);
	Evento saveOrUpdate(Evento evento);

}
