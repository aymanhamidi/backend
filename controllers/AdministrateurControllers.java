package com.ocp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocp.dao.AdministrateurDao;
import com.ocp.entities.Administrateur;
import com.ocp.dao.UtilisateurDao;
import com.ocp.entities.Utilisateur;


@RestController
@RequestMapping("/administrateur")
@CrossOrigin(origins = "http://localhost:4200/")
public class AdministrateurControllers {

    @Autowired
    private AdministrateurDao ada;
    
    @Autowired
    private UtilisateurDao uda;

    @PostMapping("/connexion")
    public ResponseEntity<?> connexionnAdministrateur(@RequestBody Administrateur administrateurData) {
        System.out.println(administrateurData);
        Administrateur administrateur=ada.findByidAdministrateur(administrateurData.getIdAdministrateur());
        if (administrateur != null && administrateur.getIdMotdePasse().equals(administrateurData.getIdMotdePasse())) {
            return ResponseEntity.ok(administrateur);
        } else {
            return ResponseEntity.badRequest().body("Identifiant ou mot de passe incorrect.");    
        }
    }

    @PostMapping("/ajouterUtilisateur")
    public ResponseEntity<?> ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            uda.save(utilisateur);
            return ResponseEntity.ok().body(utilisateur);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Une erreur est survenue lors de l'ajout de l'utilisateur.");
        }
    }
}