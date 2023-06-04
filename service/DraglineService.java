package com.ocp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ocp.dao.DraglineDao;

import com.ocp.entities.Dragline;

@Service
public class DraglineService {

	@Autowired
    private DraglineDao draglineDao;

    public List<Dragline> getAllDraglineForUtilisateur(String utilisateur) {
    	return (List<Dragline>) this.draglineDao.findByUtilisateur(utilisateur).orElse(null);
    }
}
