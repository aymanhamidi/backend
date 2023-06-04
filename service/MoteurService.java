package com.ocp.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ocp.dao.MoteurDao;
import com.ocp.entities.Moteur;

@Service
public class MoteurService {
	    
	    @Autowired
	    private MoteurDao moteurDao;

	    public List<Moteur> getAllMoteurForUtilisateur(String utilisateur) {
	    	return (List<Moteur>) this.moteurDao.findByUtilisateur(utilisateur).orElse(null);
	    }

}
