package it.racinghub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_regolamento")
@IdClass(RegolamentoId.class)
public class Regolamento {


	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REGOLAMENTO")
	private Integer idRegolamento;

	@Id
	@ManyToOne
	@JoinColumn(name = "ID_REGOLA")
	private Regola regola;

	public Integer getIdRegolamento() {
		return idRegolamento;
	}

	public void setIdRegolamento(Integer idRegolamento) {
		this.idRegolamento = idRegolamento;
	}

	public Regola getRegola() {
		return regola;
	}

	public void setRegola(Regola regola) {
		this.regola = regola;
	}

}