package com.ocp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocp.entities.Cnvab;
import com.ocp.entities.Dragline;

@Repository
public interface DraglineDao extends JpaRepository<Dragline, Long> {

	Optional<Dragline> findById(Long id);
	public void deleteById(Long id);
	Optional<Dragline> findByUtilisateur(String utilisateur);

}
