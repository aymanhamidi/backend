package com.ocp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ocp.dao.AdministrateurDao;
import com.ocp.dao.ProcessusDao;
import com.ocp.dao.UtilisateurDao;
import com.ocp.entities.Administrateur;
import com.ocp.entities.Processus;
import com.ocp.entities.Utilisateur;

import java.util.Date;

@SpringBootApplication
public class OcpBackendApplication implements CommandLineRunner {

    @Autowired
    private ProcessusDao processusDao;

    @Autowired
    private UtilisateurDao uda;

    @Autowired
    private AdministrateurDao ada;

    public static void main(String[] args) {
        SpringApplication.run(OcpBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String type = "administrateur";

        if (type.equals("administrateur")) {
            
          
           
        } else if (type.equals("utilisateur")) {
           
        }

    }
}
