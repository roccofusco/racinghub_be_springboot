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
@Table(name = "t_team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TEAM")
    private Integer idTeam;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "COLORE")
    private String colore;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "DATA_MODIFICA")
    private Timestamp dataModifica;

    @ManyToOne
    @JoinColumn(name = "ID_UTENTE")
    private Utente utente;

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public Timestamp getDataCreazione() {
		return dataModifica;
	}

	public void setDataCreazione(Timestamp dataModifica) {
		this.dataModifica = dataModifica;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}