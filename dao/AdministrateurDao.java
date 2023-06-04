package com.ocp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocp.entities.Administrateur;
import com.ocp.entities.Utilisateur;


@Repository
public interface AdministrateurDao extends JpaRepository<Administrateur, Long> {

	Administrateur findByid(Long id);
	Administrateur findByidAdministrateur(String idAdministrateur);
}
