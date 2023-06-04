package com.ocp.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ocp.dao.DraglineDao;
import com.ocp.entities.Cnvab;
import com.ocp.entities.Dragline;
import com.ocp.service.DraglineService;

@RestController
@RequestMapping("/dragline")
@CrossOrigin(origins = "http://localhost:4200/")
public class DraglineControllers {
	 @Autowired
	    private DraglineDao dda;
	 @Autowired
	    private DraglineService draglineService;
	 
	 @PostMapping("/ajouterDragline/{utilisateur}")
	 public ResponseEntity<?> ajouterDraglineForUser(@PathVariable("utilisateur") Long utilisateur, @RequestBody Dragline dragline) {
	     try {
	    	 dragline.setUtilisateur(utilisateur);
	         dda.save(dragline);
	         return ResponseEntity.ok().body(dragline);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de l'ajout de la dragline pour l'utilisateur " + utilisateur);
	     }
	 }
	 
	 @GetMapping("/listDragline")
	 public ResponseEntity<?> listDragline() {
	     try {
	         List<Dragline> listDragline = dda.findAll();
	         System.out.println(listDragline);
	         System.out.println("ok");
	         return ResponseEntity.ok().body(listDragline);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de la récupération de la liste des Dragline.");
	     }
	 }
	 
	 @GetMapping("/listDragline/{id}")
	 public ResponseEntity<?> getAllDraglineForUtilisateur(@PathVariable("id") Long id) {
	     try {
	    	 String utilisateur = id + "";
	    	List<Dragline> listDragline = new ArrayList<Dragline>();
	    	for (Iterator iterator = dda.findAll().iterator(); iterator.hasNext();) {
	    		Dragline dragline = (Dragline) iterator.next();
				if(dragline.getUtilisateur().equals(id)) {
					listDragline.add(dragline);
				}
			}
	         return ResponseEntity.ok().body(listDragline);
	     } catch (Exception e) {
	    	 return ResponseEntity.badRequest().body(e);

	     }
	 }
	 
	 @DeleteMapping("/supprimerDragline/{id}")
		public ResponseEntity<?> supprimerDragline(@PathVariable("id") Long id) {
			try {
				dda.deleteById(id);
				return ResponseEntity.ok().body("La Dragline avec l'id " + id + " a été supprimée.");
			} catch (Exception e) {
				return ResponseEntity.badRequest().body("Une erreur est survenue lors de la suppression de la Dragline avec l'id " + id + ".");
			}
		}
		
	 @PutMapping("/modifierDragline/{id}")
	 public ResponseEntity<?> modifierDragline(@PathVariable("id") Long id, @RequestBody Dragline draglineModifiee) {
	     try {
	    	 Dragline dragline = dda.findById(id).orElseThrow(() -> new RuntimeException("Dragline introuvable"));
	    	 dragline.setTemperature(draglineModifiee.getTemperature());
	    	 dragline.setPoids(draglineModifiee.getPoids());
	    	 dragline.setRotation(draglineModifiee.getRotation());
	    	 dragline.setInspectionVisuelle(draglineModifiee.getInspectionVisuelle());
	    	 dragline.setDate(draglineModifiee.getDate());
	    	 dragline.setVille(draglineModifiee.getVille());
	         dda.save(dragline);
	         return ResponseEntity.ok().body(dragline);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de la modification de la Dragline.");
	     }
	 }
	 @GetMapping("/nombre")
	 public long getNombreDragline() {
	     return dda.count();
	 }


}
