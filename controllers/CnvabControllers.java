package com.ocp.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

import com.ocp.dao.CnvabDao;
import com.ocp.dao.UtilisateurDao;
import com.ocp.entities.Cnvab;
import com.ocp.entities.Utilisateur;
import com.ocp.service.CnvabService;

@RestController
@RequestMapping("/cnvab")
@CrossOrigin(origins = "http://localhost:4200/")
public class CnvabControllers {
	 @Autowired
	    private CnvabDao cda;
	 @Autowired
	    private CnvabService cnvabService;
	 
	 @PostMapping("/ajouterCnvab/{utilisateur}")
	 public ResponseEntity<?> ajouterCnvabForUser(@PathVariable("utilisateur") Long utilisateur, @RequestBody Cnvab cnvab) {
	     try {
	         cnvab.setUtilisateur(utilisateur);
	         cda.save(cnvab);
	         return ResponseEntity.ok().body(cnvab);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de l'ajout de la Cnvab pour l'utilisateur " + utilisateur);
	     }
	 }
	 
	 @GetMapping("/listCnvab")
	 public ResponseEntity<?> listCnvab() {
	     try {
	         List<Cnvab> listCnvab = cda.findAll();
	         System.out.println(listCnvab);
	         System.out.println("ok");
	         return ResponseEntity.ok().body(listCnvab);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de la récupération de la liste des Cnvab.");
	     }
	 }
	 @GetMapping("/listCnvab/{id}")
	 public ResponseEntity<?> getAllCnvabForUtilisateur(@PathVariable("id") Long id) {
	     try {
	    	 String utilisateur = id + "";
	    	List<Cnvab> listCnvab = new ArrayList<Cnvab>();
	    	for (Iterator iterator = cda.findAll().iterator(); iterator.hasNext();) {
				Cnvab cnvab = (Cnvab) iterator.next();
				if(cnvab.getUtilisateur().equals(id)) {
					listCnvab.add(cnvab);
				}
			}
	         return ResponseEntity.ok().body(listCnvab);
	     } catch (Exception e) {
	    	 return ResponseEntity.badRequest().body(e);
 }
	 } 
	 
	 @DeleteMapping("/supprimerCnvab/{id}")
		public ResponseEntity<?> supprimerCnvab(@PathVariable("id") Long id) {
			try {
				cda.deleteById(id);
				return ResponseEntity.ok().body("La Cnvab avec l'id " + id + " a été supprimée.");
			} catch (Exception e) {
				return ResponseEntity.badRequest().body("Une erreur est survenue lors de la suppression de la Cnvab avec l'id " + id + ".");
			}
		}
		
	 @PutMapping("/modifierCnvab/{id}")
	 public ResponseEntity<?> modifierCnvab(@PathVariable("id") Long id, @RequestBody Cnvab cnvabModifiee) {
	     try {
	    	 Cnvab cnvab = cda.findById(id).orElseThrow(() -> new RuntimeException("Cnvab introuvable"));
	         cnvab.setTemperature(cnvabModifiee.getTemperature());
	         cnvab.setBruit(cnvabModifiee.getBruit());
	         cnvab.setVibration(cnvabModifiee.getVibration());
	         cnvab.setInspectionVisuelle(cnvabModifiee.getInspectionVisuelle());
	         cnvab.setDate(cnvabModifiee.getDate());
	         cnvab.setVille(cnvabModifiee.getVille());
	         cda.save(cnvab);
	         return ResponseEntity.ok().body(cnvab);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de la modification de la Cnvab.");
	     }
	 }
	 @GetMapping("/nombre")
	 public long getNombreCnvab() {
	     return cda.count();
	 }



}
