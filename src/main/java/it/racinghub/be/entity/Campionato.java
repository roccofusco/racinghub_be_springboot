package it.racinghub.be.entity;

import java.time.LocalDate;

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
@Table(name = "t_campionato")
public class Campionato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAMPIONATO")
    private Integer idCampionato;

    @Column(name = "NOME")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA_INIZIO")
    private LocalDate dataInizio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATA_FINE")
    private LocalDate dataFine;

//	@OneToMany(mappedBy = "idRegolamento")
//	private List<Regolamento> regolamento;

    @Column(name = "ID_REGOLAMENTO")
    private Integer idRegolamento;
    
    @ManyToOne
    @JoinColumn(name = "ID_UTENTE")
    private Utente utente;

	public Integer getIdCampionato() {
		return idCampionato;
	}

	public void setIdCampionato(Integer idCampionato) {
		this.idCampionato = idCampionato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

//	public List<Regolamento> getRegolamento() {
//		return regolamento;
//	}
//
//	public void setRegolamento(List<Regolamento> regolamento) {
//		this.regolamento = regolamento;
//	}
	
	public Integer getIdRegolamento() {
		return idRegolamento;
	}

	public void setIdRegolamento(Integer idRegolamento) {
		this.idRegolamento = idRegolamento;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}