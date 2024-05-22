package it.racinghub.be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.Evento;
import it.racinghub.be.repository.EventoRepository;
import it.racinghub.be.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	@Override
	public List<Evento> getEventByIdCampionato(String idCampionato) {
		Campionato c = new Campionato() {
			{
				setIdCampionato(Integer.parseInt(idCampionato));
			}
		};

		return eventoRepository.findByCampionato(c);
	}

	@Override
	public Evento getEventById(String idEvento) {
		return eventoRepository.findById(Integer.parseInt(idEvento)).get();
	}

	@Override
	public Evento saveOrUpdate(Evento evento) {

		return eventoRepository.save(evento);
	}
}