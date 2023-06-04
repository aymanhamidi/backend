package com.ocp.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "processus")
public class Processus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomProcessus;
	
	
	private Date date;
	private String ville;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomProcessus() {
		return nomProcessus;
	}

	public void setNomProcessus(String nomProcessus) {
		this.nomProcessus = nomProcessus;
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

	public Processus(Long id, String nomProcessus, Date date, String ville) {
		super();
		this.id = id;
		this.nomProcessus = nomProcessus;
		this.date = date;
		this.ville = ville;
	}

	public Processus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}