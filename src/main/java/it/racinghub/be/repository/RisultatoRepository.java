package it.racinghub.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.racinghub.be.entity.Risultato;
import it.racinghub.be.entity.Sessione;

@Repository
public interface RisultatoRepository extends JpaRepository<Risultato, Integer> {
	
	@Transactional
	public void deleteBySessione(Sessione sessione);
	
	@Procedure(procedureName = "set_puntibonus_risultato")
	public void assegnaPuntiBonus(int i_id_sessione);
}
