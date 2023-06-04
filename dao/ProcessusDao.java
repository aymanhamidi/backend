package com.ocp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ocp.entities.Processus;

@Repository
public interface ProcessusDao extends JpaRepository<Processus, Long>{

	
}
