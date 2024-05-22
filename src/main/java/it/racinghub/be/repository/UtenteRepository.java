package it.racinghub.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.racinghub.be.entity.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	
	public Utente findByTelegramId(String telegramId);
}
