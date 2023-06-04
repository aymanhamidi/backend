package com.ocp.dao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ocp.entities.Moteur;

@Repository
public interface MoteurDao extends JpaRepository<Moteur, Long> {
	Optional<Moteur> findById(Long id);
	public void deleteById(Long id);
	Optional<Moteur> findByUtilisateur(String utilisateur);


}
