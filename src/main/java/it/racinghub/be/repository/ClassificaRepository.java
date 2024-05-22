package it.racinghub.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.Classifica;

@Repository
public interface ClassificaRepository extends JpaRepository<Classifica, Integer> {
	
	List<Classifica> findByCampionatoOrderByPosizione(Campionato campionato);
}
