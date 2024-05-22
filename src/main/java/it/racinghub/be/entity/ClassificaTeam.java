package it.racinghub.be.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "v_classifica_team")
public class ClassificaTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLASSIFICA_TEAM")
    private Integer idClassificaTeam;
	
    @ManyToOne
    @JoinColumn(name = "ID_CAMPIONATO",  insertable = false, updatable = false,
        	foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Campionato campionato;

    @Column(name = "POSIZIONE")
    private Integer posizione;

    @ManyToOne()
    @JoinColumn(name = "ID_TEAM", insertable = false, updatable = false,
    	foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Team team;

    @Column(name = "PUNTI")
    private BigDecimal punti;


	public Integer getIdClassificaTeam() {
		return idClassificaTeam;
	}

	public void setIdClassificaTeam(Integer idClassificaTeam) {
		this.idClassificaTeam = idClassificaTeam;
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