package it.racinghub.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.racinghub.be.entity.Pilota;
import it.racinghub.be.entity.Team;
import it.racinghub.be.entity.Utente;

public interface PilotaRepository extends JpaRepository<Pilota, Integer> {
	
	public Pilota findByUtente(Utente utente);
	
	public List<Pilota> findByTeam(Team team);


}
