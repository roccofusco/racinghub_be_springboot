package it.racinghub.be.service;

import java.util.List;

import it.racinghub.be.entity.Sessione;

public interface SessioneService {

	public List<Sessione> getSessionByIdEvento(String idEvento);
	public Sessione getSessionById(String idSessione);
	Sessione saveOrUpdate(Sessione sessione);

}
