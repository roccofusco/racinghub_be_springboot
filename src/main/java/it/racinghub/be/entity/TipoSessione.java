package it.racinghub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_tipo_sessione")
public class TipoSessione {

    @Id
    @Column(name = "ID_TIPO_SESSIONE")
    private String idTipoSessione;

    @Column(name = "DESCRIZIONE")
    private String descrizione;

	public String getIdTipoSessione() {
		return idTipoSessione;
	}

	public void setIdTipoSessione(String idTipoSessione) {
		this.idTipoSessione = idTipoSessione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
