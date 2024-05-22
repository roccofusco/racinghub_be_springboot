package it.racinghub.be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.racinghub.be.entity.Evento;
import it.racinghub.be.entity.Sessione;
import it.racinghub.be.repository.SessioneRepository;
import it.racinghub.be.service.SessioneService;

@Service
public class SessioneServiceImpl  implements SessioneService{

    @Autowired
    private SessioneRepository sessioneRepository;

	@Override
	public List<Sessione> getSessionByIdEvento(String idEvento) {
		Evento e = new Evento() {{setIdEvento(Integer.parseInt(idEvento));}};
		
		return sessioneRepository.findByEvento(e);
	}

	@Override
	public Sessione getSessionById(String idSessione) {

		return sessioneRepository.findById(Integer.parseInt(idSessione)).get();
	}

	@Override
	public Sessione saveOrUpdate(Sessione sessione) {

		return sessioneRepository.save(sessione);
	}
}