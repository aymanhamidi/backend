package com.ocp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocp.entities.Cnvab;
import com.ocp.entities.Utilisateur;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>{

	Optional<Utilisateur> findByid(Long id);
	Utilisateur findByidUtilisateur(String idUtilisateur);
	
	
}
