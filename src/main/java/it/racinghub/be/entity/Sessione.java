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
@Table(name = "t_sessione")
public class Sessione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SESSIONE")
    private Integer idSessione;

    @Column(name = "NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_EVENTO")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_SESSIONE")
    private TipoSessione tipoSessione;

    @Column(name = "DURATA")
    private BigDecimal durata;

    @Column(name = "UNITA_DURATA")
    private String unitaDurata;

    @Column(name = "PERCENT_DURATA")
    private BigDecimal percentDurata;

    @Column(name = "NOTE")
    private String note;

	public Integer getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Integer idSessione) {
		this.idSessione = idSessione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public TipoSessione getTipoSessione() {
		return tipoSessione;
	}

	public void setTipoSessione(TipoSessione tipoSessione) {
		this.tipoSessione = tipoSessione;
	}

	public BigDecimal getDurata() {
		return durata;
	}

	public void setDurata(BigDecimal durata) {
		this.durata = durata;
	}

	public String getUnitaDurata() {
		return unitaDurata;
	}

	public void setUnitaDurata(String unitaDurata) {
		this.unitaDurata = unitaDurata;
	}

	public BigDecimal getPercentDurata() {
		return percentDurata;
	}

	public void setPercentDurata(BigDecimal percentDurata) {
		this.percentDurata = percentDurata;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}