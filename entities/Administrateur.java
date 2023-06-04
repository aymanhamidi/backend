package com.ocp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="connexionnAdministrateur")
public class Administrateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String idAdministrateur;
	private String idMotdePasse;
	private String role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdAdministrateur() {
		return idAdministrateur;
	}
	public void setIdAdministrateur(String idAdministrateur) {
		this.idAdministrateur = idAdministrateur;
	}
	public String getIdMotdePasse() {
		return idMotdePasse;
	}
	public void setIdMotdePasse(String idMotdePasse) {
		this.idMotdePasse = idMotdePasse;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Administrateur(Long id, String idAdministrateur, String idMotdePasse, String role) {
		super();
		this.id = id;
		this.idAdministrateur = idAdministrateur;
		this.idMotdePasse = idMotdePasse;
		this.role = role;
	}
	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
