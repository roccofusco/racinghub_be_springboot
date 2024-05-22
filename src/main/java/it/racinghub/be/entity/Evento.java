package it.racinghub.be.entity;

import java.math.BigDecimal;
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
@Table(name = "t_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVENTO")
    private Integer idEvento;

    @Column(name = "NOME")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "DATA_INIZIO")
    private Timestamp dataInizio;

    @Column(name = "QUOTA_ISCRIZIONE")
    private BigDecimal quotaIscrizione;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "SCADENZA_ISCRIZIONE")
    private Timestamp scadenzaIscrizione;

    @ManyToOne
    @JoinColumn(name = "ID_PISTA")
    private Pista pista;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPIONATO")
    private Campionato campionato;

	public Integer getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Timestamp getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Timestamp dataInizio) {
		this.dataInizio = dataInizio;
	}

	public BigDecimal getQuotaIscrizione() {
		return quotaIscrizione;
	}

	public void setQuotaIscrizione(BigDecimal quotaIscrizione) {
		this.quotaIscrizione = quotaIscrizione;
	}

	public Timestamp getScadenzaIscrizione() {
		return scadenzaIscrizione;
	}

	public void setScadenzaIscrizione(Timestamp scadenzaIscrizione) {
		this.scadenzaIscrizione = scadenzaIscrizione;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}

	public Campionato getCampionato() {
		return campionato;
	}

	public void setCampionato(Campionato campionato) {
		this.campionato = campionato;
	}

}