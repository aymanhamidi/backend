package com.ocp.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "moteur")
public class Moteur {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private int temperature;
		private int vitesse;
		private int consommation;
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


		public int getVitesse() {
			return vitesse;
		}


		public void setVitesse(int vitesse) {
			this.vitesse = vitesse;
		}


		public int getConsommation() {
			return consommation;
		}


		public void setConsommation(int consommation) {
			this.consommation = consommation;
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


		public Moteur(Long id, int temperature, int vitesse, int consommation, String inspectionVisuelle, Date date,
				String ville, Long utilisateur) {
			super();
			this.id = id;
			this.temperature = temperature;
			this.vitesse = vitesse;
			this.consommation = consommation;
			this.inspectionVisuelle = inspectionVisuelle;
			this.date = date;
			this.ville = ville;
			this.utilisateur = utilisateur;
		}


		public Moteur() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		

}
