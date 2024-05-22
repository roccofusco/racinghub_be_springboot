package it.racinghub.be.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.racinghub.be.entity.Campionato;
import it.racinghub.be.entity.Evento;
import it.racinghub.be.entity.IscrizioneEvento;
import it.racinghub.be.entity.Pilota;
import it.racinghub.be.repository.IscrizioneEventoRepository;
import it.racinghub.be.repository.PilotaRepository;
import it.racinghub.be.service.IscrizioneEventoService;

@Service
public class IscrizioneEventoServiceImpl  implements IscrizioneEventoService{

    @Autowired
    private IscrizioneEventoRepository iscrizioneEventoRepository;

    @Autowired
    private PilotaRepository pilotaRepository;
    
	@Override
	public List<Campionato> getChampionshipByIdPilotaIscritto(String idPilota) {
		Pilota p = new Pilota() {{setIdPilota(Integer.parseInt(idPilota));}};
		
//		List<IscrizioneEvento> fefu = iscrizioneEventoRepository.findDistinctEventoCampionatoByPilota(p);
//		return null;
		
		return iscrizioneEventoRepository.findDistinctEventoCampionatoByPilota(p);
	}

	@Override
	public List<IscrizioneEvento> getRegisteredEventsByIdEvento(String idEvento) {
		Evento e = new Evento() {{setIdEvento(Integer.parseInt(idEvento));}};
		
		return iscrizioneEventoRepository.findByEventoOrderByTargaVeicolo(e);
	}

	@Override
	public IscrizioneEvento saveOrUpdate(IscrizioneEvento iscrizioneEvento) {

		Optional<Pilota> op = pilotaRepository.findById(iscrizioneEvento.getPilota().getIdPilota());
		if(op.isPresent()) {
			iscrizioneEvento.setTeam(op.get().getTeam());
		}

		Optional<IscrizioneEvento> oie = iscrizioneEventoRepository.findByPilotaAndEvento(iscrizioneEvento.getPilota(), iscrizioneEvento.getEvento());
		if(oie.isPresent()) {
			iscrizioneEvento.setIdIscrizioneEvento(oie.get().getIdIscrizioneEvento());
		}
		
		return iscrizioneEventoRepository.save(iscrizioneEvento);
	}

}