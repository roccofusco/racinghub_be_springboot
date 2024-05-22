package it.racinghub.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.ClassificaTeam;

@Repository
public interface ClassificaTeamRepository extends JpaRepository<ClassificaTeam, Integer> {
	
	List<ClassificaTeam> findByCampionatoOrderByPosizione(Campionato campionato);
	
}
