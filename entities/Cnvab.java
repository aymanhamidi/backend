package com.ocp.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cnvab")
public class Cnvab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int temperature;
	private int bruit;
	private int vibration;
	private String inspectionVisuelle;
	@Column(nullable = false, updatable = true)
	private Date date;
	private String ville;
	
	
	@Column(nullable = false, updatable = true)
	private Long utilisateur;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getTemperature() {
		return temperature;
	}


	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}


	public int getBruit() {
		return bruit;
	}


	public void setBruit(int bruit) {
		this.bruit = bruit;
	}


	public int getVibration() {
		return vibration;
	}


	public void setVibration(int vibration) {
		this.vibration = vibration;
	}


	public String getInspectionVisuelle() {
		return inspectionVisuelle;
	}


	public void setInspectionVisuelle(String inspectionVisuelle) {
		this.inspectionVisuelle = inspectionVisuelle;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public Long getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Long utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Cnvab(Long id, int temperature, int bruit, int vibration, String inspectionVisuelle, Date date, String ville,
			Long utilisateur) {
		super();
		this.id = id;
		this.temperature = temperature;
		this.bruit = bruit;
		this.vibration = vibration;
		this.inspectionVisuelle = inspectionVisuelle;
		this.date = date;
		this.ville = ville;
		this.utilisateur = utilisateur;
	}


	public Cnvab() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
