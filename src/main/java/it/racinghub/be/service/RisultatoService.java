package it.racinghub.be.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.racinghub.be.entity.Risultato;

public interface RisultatoService {

	public boolean verifyFile(MultipartFile file, String fileName);

	public List<Risultato> getListRisultatoFromFile(MultipartFile file, String fileName, int idSessione);
	
	public void cancellaRisultatiBySessione(int idSessione);
	
	public void importaRisultato(List<Risultato> listRisultato, int idSessione);

}
