package com.ocp.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;




@Entity
@Table(name="connexionnUtilisateur")

public class Utilisateur {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String idUtilisateur;
	private String idMotdePasse;
	private String nomComplet;
	private int numTelephone;
	private boolean sexe;
	private String grade;
	private String role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getIdMotdePasse() {
		return idMotdePasse;
	}
	public void setIdMotdePasse(String idMotdePasse) {
		this.idMotdePasse = idMotdePasse;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public int getNumTelephone() {
		return numTelephone;
	}
	public void setNumTelephone(int numTelephone) {
		this.numTelephone = numTelephone;
	}
	public boolean isSexe() {
		return sexe;
	}
	public void setSexe(boolean sexe) {
		this.sexe = sexe;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Utilisateur(Long id, String idUtilisateur, String idMotdePasse, String nomComplet, int numTelephone,
			boolean sexe, String grade, String role) {
		super();
		this.id = id;
		this.idUtilisateur = idUtilisateur;
		this.idMotdePasse = idMotdePasse;
		this.nomComplet = nomComplet;
		this.numTelephone = numTelephone;
		this.sexe = sexe;
		this.grade = grade;
		this.role = role;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	

	
}
