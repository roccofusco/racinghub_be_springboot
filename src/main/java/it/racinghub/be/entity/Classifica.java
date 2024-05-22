package it.racinghub.be.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_classifica")
public class Classifica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLASSIFICA")
    private Integer idClassifica;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPIONATO")
    private Campionato campionato;

    @Column(name = "POSIZIONE")
    private Integer posizione;

    @ManyToOne
    @JoinColumn(name = "ID_PILOTA")
    private Pilota pilota;

    @ManyToOne
    @JoinColumn(name = "ID_TEAM")
    private Team team;

    @Column(name = "PUNTI")
    private BigDecimal punti;

	public Integer getIdClassifica() {
		return idClassifica;
	}

	public void setIdClassifica(Integer idClassifica) {
		this.idClassifica = idClassifica;
	}

	public Campionato getCampionato() {
		return campionato;
	}

	public void setCampionato(Campionato campionato) {
		this.campionato = campionato;
	}

	public Integer getPosizione() {
		return posizione;
	}

	public void setPosizione(Integer posizione) {
		this.posizione = posizione;
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

	public BigDecimal getPunti() {
		return punti;
	}

	public void setPunti(BigDecimal punti) {
		this.punti = punti;
	}

}