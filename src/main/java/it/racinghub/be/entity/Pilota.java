package it.racinghub.be.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_pilota")
public class Pilota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PILOTA")
    private Integer idPilota;

    @Column(name = "COGNOME")
    private String cognome;

    @Column(name = "NOME")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA_NASCITA")
    private LocalDate dataNascita;

    @Column(name = "PESO_KG")
    private BigDecimal pesoKg;

    @Column(name = "CELLULARE")
    private String cellulare;

    @ManyToOne
    @JoinColumn(name = "ID_TEAM")
    private Team team;

    @OneToOne
    @JoinColumn(name = "ID_UTENTE")
    private Utente utente;
    
	public Integer getIdPilota() {
		return idPilota;
	}

	public void setIdPilota(Integer idPilota) {
		this.idPilota = idPilota;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public BigDecimal getPesoKg() {
		return pesoKg;
	}

	public void setPesoKg(BigDecimal pesoKg) {
		this.pesoKg = pesoKg;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}