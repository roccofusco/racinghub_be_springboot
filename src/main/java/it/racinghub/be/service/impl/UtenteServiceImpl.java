package it.racinghub.be.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.racinghub.be.entity.Utente;
import it.racinghub.be.repository.UtenteRepository;
import it.racinghub.be.service.UtenteService;

@Service
public class UtenteServiceImpl  implements UtenteService{

    @Autowired
    private UtenteRepository utenteRepository;

	@Override
	public Utente saveOrUpdate(Utente utente) {
		Utente existingUser = utenteRepository.findByTelegramId(utente.getTelegramId());
        if (Objects.nonNull(existingUser)) {
        	existingUser.setUserTelegram(utente.getUserTelegram());
        	return utenteRepository.save(existingUser);
		}
        return utenteRepository.save(utente);
	}

}