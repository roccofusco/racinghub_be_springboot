package it.racinghub.be.entity;

import java.io.Serializable;

public class RegolamentoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6372630712964216189L;

	private Integer idRegolamento;

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