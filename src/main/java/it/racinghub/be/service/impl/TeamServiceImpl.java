package it.racinghub.be.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.racinghub.be.entity.Pilota;
import it.racinghub.be.entity.Team;
import it.racinghub.be.repository.PilotaRepository;
import it.racinghub.be.repository.TeamRepository;
import it.racinghub.be.service.TeamService;

@Service
public class TeamServiceImpl  implements TeamService{

    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private PilotaRepository pilotaRepository;

	@Override
	public Team saveOrUpdate(Team team) {

		team.setDataCreazione(new Timestamp(System.currentTimeMillis()));
		Team t = teamRepository.save(team);

		//Se il team è nuovo, setto la squadra al pilota
		Pilota p = pilotaRepository.findByUtente(t.getUtente());
		p.setTeam(t);
		pilotaRepository.save(p);
		
        return t;
	}

}