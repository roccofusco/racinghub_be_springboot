package it.racinghub.be.service;

import java.util.List;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.IscrizioneEvento;

public interface IscrizioneEventoService {

	public List<Campionato> getChampionshipByIdPilotaIscritto(String idPilota);
	public List<IscrizioneEvento> getRegisteredEventsByIdEvento(String idEvento);
	public IscrizioneEvento saveOrUpdate(IscrizioneEvento iscrizioneEvento);
}
