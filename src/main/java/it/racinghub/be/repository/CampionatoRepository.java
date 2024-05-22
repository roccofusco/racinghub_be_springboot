package it.racinghub.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.Utente;

@Repository
public interface CampionatoRepository extends JpaRepository<Campionato, Integer> {
	
	public List<Campionato> findByUtente(Utente utente);

}
