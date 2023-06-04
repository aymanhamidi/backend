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

import com.ocp.dao.UtilisateurDao;
import com.ocp.entities.Cnvab;
import com.ocp.entities.Utilisateur;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin(origins = "http://localhost:4200/")
public class UtilisateurControllers {
	
	@Autowired
	private UtilisateurDao uda;
	
	@PostMapping("/connexion")
	public ResponseEntity<?> connexionnUtilisateur(@RequestBody Utilisateur utilisateurData) {
		System.out.println(utilisateurData);
		Utilisateur utilisateur=uda.findByidUtilisateur(utilisateurData.getIdUtilisateur());
		if (utilisateur != null && utilisateur.getIdMotdePasse().equals(utilisateurData.getIdMotdePasse())) {
			return ResponseEntity.ok(utilisateur);
		} else {
			return ResponseEntity.badRequest().body("Identifiant ou mot de passe incorrect.");	
	}
	}
	
	@GetMapping("/listUtilisateur/{id}") 
	public ResponseEntity<?> getAllInfoUtilisateur(@PathVariable("id") Long id) {
	    try {
	    	Long Id = id;
	        List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
	        for (Iterator iterator = uda.findAll().iterator(); iterator.hasNext();) {
	            Utilisateur user = (Utilisateur) iterator.next();
	            if (user.getId().equals(Id)) {
	                listUtilisateur.add(user);
	            }
	        }
	        return ResponseEntity.ok().body(listUtilisateur);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body(e);
	    }
	}
	
	 @PutMapping("/modifierUtilisateur/{id}")
	 public ResponseEntity<?> modifierUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateurModifiee) {
	     try {
	    	 Utilisateur utilisateur = uda.findByid(id).orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
	    	 utilisateur.setIdUtilisateur(utilisateurModifiee.getIdUtilisateur());
	    	 utilisateur.setIdMotdePasse(utilisateurModifiee.getIdMotdePasse());
	    	 utilisateur.setNomComplet(utilisateurModifiee.getNomComplet());
	    	 utilisateur.setNumTelephone(utilisateurModifiee.getNumTelephone());
	    	 utilisateur.setSexe(utilisateurModifiee.isSexe());
	    	 utilisateur.setGrade(utilisateurModifiee.getGrade());
	    	 utilisateur.setRole(utilisateurModifiee.getRole());
	    	 uda.save(utilisateur);
	         return ResponseEntity.ok().body(utilisateur);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de la modification de la Utilisateur.");
	     }
	 }
	 
	 @GetMapping("/listUtilisateur")
	 public ResponseEntity<?> listUtilisateur() {
	     try {
	         List<Utilisateur> listUtilisateur = uda.findAll();
	         System.out.println(listUtilisateur);
	         System.out.println("ok");
	         return ResponseEntity.ok().body(listUtilisateur);
	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de la récupération de la liste des Utilisateur.");
	     }
	 }
	 @DeleteMapping("/supprimerUtilisateur/{id}")
		public ResponseEntity<?> supprimerUtilisateur(@PathVariable("id") Long id) {
			try {
				uda.deleteById(id);
				return ResponseEntity.ok().body("La Utilisateur avec l'id " + id + " a été supprimée.");
			} catch (Exception e) {
				return ResponseEntity.badRequest().body("Une erreur est survenue lors de la suppression de la Utilisateur avec l'id " + id + ".");
			}
		}
	 @GetMapping("/nombre")
	 public long getNombreUtilisateurs() {
	     return uda.count();
	 }
	 
}
