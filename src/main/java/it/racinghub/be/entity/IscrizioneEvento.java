package it.racinghub.be.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_iscrizione_evento")
public class IscrizioneEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ISCRIZIONE_EVENTO")
    private Integer idIscrizioneEvento;

    @Column(name = "TARGA_VEICOLO")
    private String targaVeicolo;

    @ManyToOne
    @JoinColumn(name = "ID_PILOTA")
    private Pilota pilota;

    @ManyToOne
    @JoinColumn(name = "ID_TEAM")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "ID_EVENTO")
    private Evento evento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "DATA_PAGAMENTO")
    private Timestamp dataPagamento;

	public Integer getIdIscrizioneEvento() {
		return idIscrizioneEvento;
	}

	public void setIdIscrizioneEvento(Integer idIscrizioneEvento) {
		this.idIscrizioneEvento = idIscrizioneEvento;
	}

	public String getTargaVeicolo() {
		return targaVeicolo;
	}

	public void setTargaVeicolo(String targaVeicolo) {
		this.targaVeicolo = targaVeicolo;
	}

	public Pilota getPilota() {
		return pilota;
	}

	public void setPilota(Pilota pilota) {
		this.pilota = pilota;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Timestamp getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Timestamp dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
