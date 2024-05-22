package it.racinghub.be.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UTENTE")
    private Integer idUtente;

    @Column(name = "TELEGRAM_ID")
    private String telegramId;
    
    @Column(name = "USER_TELEGRAM")
    private String userTelegram;

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public String getTelegramId() {
		return telegramId;
	}

	public void setTelegramId(String telegramId) {
		this.telegramId = telegramId;
	}

	public String getUserTelegram() {
		return userTelegram;
	}

	public void setUserTelegram(String userTelegram) {
		this.userTelegram = userTelegram;
	}

}