package com.ocp.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dragline")
public class Dragline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int temperature;
	private int poids;
	private int rotation;
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


	public int getPoids() {
		return poids;
	}


	public void setPoids(int poids) {
		this.poids = poids;
	}


	public int getRotation() {
		return rotation;
	}


	public void setRotation(int rotation) {
		this.rotation = rotation;
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


	public Dragline(Long id, int temperature, int poids, int rotation, String inspectionVisuelle, Date date,
			String ville, Long utilisateur) {
		super();
		this.id = id;
		this.temperature = temperature;
		this.poids = poids;
		this.rotation = rotation;
		this.inspectionVisuelle = inspectionVisuelle;
		this.date = date;
		this.ville = ville;
		this.utilisateur = utilisateur;
	}


	public Dragline() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
