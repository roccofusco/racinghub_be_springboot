package it.racinghub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_regola")
public class Regola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REGOLA")
    private Integer idRegola;

    @Column(name = "GRUPPO_REGOLA")
    private String gruppoRegola;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_SESSIONE")
    private TipoSessione tipoSessione;

    @Column(name = "DOMINIO")
    private String dominio;

    @Column(name = "CHIAVE")
    private String chiave;

    @Column(name = "VALORE")
    private String valore;

	public Integer getIdRegola() {
		return idRegola;
	}

	public void setIdRegola(Integer idRegola) {
		this.idRegola = idRegola;
	}

	public String getGruppoRegola() {
		return gruppoRegola;
	}

	public void setGruppoRegola(String gruppoRegola) {
		this.gruppoRegola = gruppoRegola;
	}

	public TipoSessione getIdTipoSessione() {
		return tipoSessione;
	}

	public void setIdTipoSessione(TipoSessione tipoSessione) {
		this.tipoSessione = tipoSessione;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getChiave() {
		return chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

}