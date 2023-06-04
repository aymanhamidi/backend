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
import com.ocp.dao.MoteurDao;
import com.ocp.entities.Cnvab;
import com.ocp.entities.Moteur;
import com.ocp.service.MoteurService;

@RestController
@RequestMapping("/moteur")
@CrossOrigin(origins = "http://localhost:4200/")
public class MoteurControllers {
	
		@Autowired
	    private MoteurDao mda;
	 @Autowired
	    private MoteurService moteurService;
	 
	 @PostMapping("/ajouterMoteur/{utilisateur}")
	 public ResponseEntity<?> ajouterMoteurForUser(@PathVariable("utilisateur") Long utilisateur, @RequestBody Moteur moteur) {
	     try {
	    	 moteur.setUtilisateur(utilisateur);
	         mda.save(moteur);
	         return ResponseEntity.ok().body(moteur);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de l'ajout de la Moteur pour l'utilisateur " + utilisateur);
	     }
	 }
	 
	 @GetMapping("/listMoteur")
	 public ResponseEntity<?> listMoteur() {
	     try {
	         List<Moteur> listMoteur= mda.findAll();
	         System.out.println(listMoteur);
	         System.out.println("ok");
	         return ResponseEntity.ok().body(listMoteur);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de la récupération de la liste des Moteur.");
	     }
	 }
	 
	 @GetMapping("/listMoteur/{id}")
	 public ResponseEntity<?> getAllMoteurForUtilisateur(@PathVariable("id") Long id) {
	     try {
	    	 String utilisateur = id + "";
	    	List<Moteur> listMoteur = new ArrayList<Moteur>();
	    	for (Iterator iterator = mda.findAll().iterator(); iterator.hasNext();) {
	    		Moteur moteur = (Moteur) iterator.next();
				if(moteur.getUtilisateur().equals(id)) {
					listMoteur.add(moteur);
				}
			}
	         return ResponseEntity.ok().body(listMoteur);
	     } catch (Exception e) {
	    	 return ResponseEntity.badRequest().body(e);
	}
	 }
	 
	 @DeleteMapping("/supprimerMoteur/{id}")
		public ResponseEntity<?> supprimerMoteur(@PathVariable("id") Long id) {
			try {
				mda.deleteById(id);
				return ResponseEntity.ok().body("La Moteur avec l'id " + id + " a été supprimée.");
			} catch (Exception e) {
				return ResponseEntity.badRequest().body("Une erreur est survenue lors de la suppression de la Moteur avec l'id " + id + ".");
			}
		}
		
	@PutMapping("/modifierMoteur/{id}")
	public ResponseEntity<?> modifierMoteur(@PathVariable("id") Long id, @RequestBody Moteur moteurModifiee) {
	  try {
		  Moteur moteur = mda.findById(id).orElseThrow(() -> new RuntimeException("Moteur introuvable"));
		  moteur.setTemperature(moteurModifiee.getTemperature());
		  moteur.setVitesse(moteurModifiee.getVitesse());
		  moteur.setConsommation(moteurModifiee.getConsommation());
		  moteur.setInspectionVisuelle(moteurModifiee.getInspectionVisuelle());
		  moteur.setDate(moteurModifiee.getDate());
		  moteur.setVille(moteurModifiee.getVille());
	      mda.save(moteur);
	      return ResponseEntity.ok().body(moteur);
	  } catch (Exception e) {
	      return ResponseEntity.badRequest().body("Une erreur est survenue lors de la modification de la Moteur.");
	  }
	}

}
