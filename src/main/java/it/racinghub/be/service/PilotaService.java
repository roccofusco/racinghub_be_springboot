package it.racinghub.be.service;

import java.util.List;

import it.racinghub.be.entity.Pilota;

public interface PilotaService {

	public Pilota getDriverByIdUtente(String idUtente);
	public List<Pilota> getDriverByIdTeam(String idTeam);
	public Pilota getDriverById(String idPilota);
	public Pilota saveOrUpdate(Pilota pilota);
	
	public Pilota updateCoDriverTeam(String idPilota, String idTeam);

}
