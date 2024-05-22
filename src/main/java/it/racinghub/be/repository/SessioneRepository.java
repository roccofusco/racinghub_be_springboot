package it.racinghub.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.Evento;
import it.racinghub.be.entity.Sessione;

@Repository
public interface SessioneRepository extends JpaRepository<Sessione, Integer> {
	
	public List<Sessione> findByEvento(Evento evento);

	public Sessione findByIdSessione(Integer idSessione);

}
