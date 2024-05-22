package it.racinghub.be.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.Evento;
import it.racinghub.be.entity.IscrizioneEvento;
import it.racinghub.be.entity.Pilota;

@Repository
public interface IscrizioneEventoRepository extends JpaRepository<IscrizioneEvento, Integer> {
	
	public IscrizioneEvento findByTargaVeicoloAndEvento(String targaVeicolo, Evento evento);
	
	@Query("SELECT DISTINCT ie.evento.campionato FROM IscrizioneEvento ie WHERE ie.pilota = :pilota ")
	public List<Campionato> findDistinctEventoCampionatoByPilota(Pilota pilota);
	
	public List<IscrizioneEvento> findByEventoOrderByTargaVeicolo(Evento evento);

	public Optional<IscrizioneEvento> findByPilotaAndEvento(Pilota pilota, Evento evento);

	
}
