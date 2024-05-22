package it.racinghub.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
	
	public List<Evento> findByCampionato(Campionato campionato);

}
