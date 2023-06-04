package com.ocp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocp.dao.CnvabDao;
import com.ocp.entities.Cnvab;

@Service
public class CnvabService { 
    
    @Autowired
    private CnvabDao cnvabDao;

    public List<Cnvab> getAllCnvabForUtilisateur(String utilisateur) {
    	return (List<Cnvab>) this.cnvabDao.findByUtilisateur(utilisateur).orElse(null);
    }

}
