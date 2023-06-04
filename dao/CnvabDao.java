package com.ocp.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocp.entities.Cnvab;
import com.ocp.entities.Processus;

@Repository
public interface CnvabDao extends JpaRepository<Cnvab, Long>{
	Optional<Cnvab> findById(Long id);
	public void deleteById(Long id);
	Optional<Cnvab> findByUtilisateur(String utilisateur);

}
