package it.racinghub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_pista")
public class Pista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PISTA")
    private Integer idPista;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "INDIRIZZO")
    private String indirizzo;

    @Column(name = "CITTA")
    private String citta;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "CAP")
    private String cap;

	public Integer getIdPista() {
		return idPista;
	}

	public void setIdPista(Integer idPista) {
		this.idPista = idPista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

}