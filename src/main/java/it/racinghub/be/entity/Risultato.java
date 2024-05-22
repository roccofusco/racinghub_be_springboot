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
@Table(name = "t_risultato")
public class Risultato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RISULTATO")
    private Integer idRisultato;

    @ManyToOne
    @JoinColumn(name = "ID_SESSIONE")
    private Sessione sessione;

    @Column(name = "POSIZIONE")
    private String posizione;

    @ManyToOne
    @JoinColumn(name = "ID_ISCRIZIONE_EVENTO")
    private IscrizioneEvento iscrizioneEvento;

    @Column(name = "N_LAP")
    private Integer nLap;

    @JsonFormat(pattern = "HH:mm:ss.SSS")
    @Column(name = "GAP_TO_LEADER", columnDefinition = "TIME(3)")
    private Timestamp gapToLeader;

    @JsonFormat(pattern = "HH:mm:ss.SSS")
    @Column(name = "GAP_TO_POSITION", columnDefinition = "TIME(3)")
    private Timestamp gapToPosition;

    @JsonFormat(pattern = "HH:mm:ss.SSS")
    @Column(name = "BEST_LAP", columnDefinition = "TIME(3)")
    private Timestamp bestLap;

    @JsonFormat(pattern = "HH:mm:ss.SSS")
    @Column(name = "TOTAL_TIME", columnDefinition = "TIME(3)")
    private Timestamp totalTime;

    @Column(name = "PUNTI")
    private BigDecimal punti;

	public Integer getIdRisultato() {
		return idRisultato;
	}

	public void setIdRisultato(Integer idRisultato) {
		this.idRisultato = idRisultato;
	}

	public Sessione getSessione() {
		return sessione;
	}

	public void setSessione(Sessione sessione) {
		this.sessione = sessione;
	}

	public String getPosizione() {
		return posizione;
	}

	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}

	public IscrizioneEvento getIscrizioneEvento() {
		return iscrizioneEvento;
	}

	public void setIscrizioneEvento(IscrizioneEvento iscrizioneEvento) {
		this.iscrizioneEvento = iscrizioneEvento;
	}

	public Integer getnLap() {
		return nLap;
	}

	public void setnLap(Integer nLap) {
		this.nLap = nLap;
	}

	public Timestamp getGapToLeader() {
		return gapToLeader;
	}

	public void setGapToLeader(Timestamp gapToLeader) {
		this.gapToLeader = gapToLeader;
	}

	public Timestamp getGapToPosition() {
		return gapToPosition;
	}

	public void setGapToPosition(Timestamp gapToPosition) {
		this.gapToPosition = gapToPosition;
	}

	public Timestamp getBestLap() {
		return bestLap;
	}

	public void setBestLap(Timestamp bestLap) {
		this.bestLap = bestLap;
	}

	public Timestamp getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Timestamp totalTime) {
		this.totalTime = totalTime;
	}

	public BigDecimal getPunti() {
		return punti;
	}

	public void setPunti(BigDecimal punti) {
		this.punti = punti;
	}

}
