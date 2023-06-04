package com.ocp.controllers;

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

import com.ocp.dao.CnvabDao;
import com.ocp.dao.ProcessusDao;
import com.ocp.entities.Cnvab;
import com.ocp.entities.Processus;

@RestController
@RequestMapping("/processus")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProcessusController {

	@Autowired
	private ProcessusDao processusDao;
	 @Autowired
	    private CnvabDao cda;

	@GetMapping
	public List<Processus> getProcessus() {
		return processusDao.findAll();
	}

	@GetMapping("/{id}")
	public Processus getProcessusById(@PathVariable Long id) {
		return processusDao.findById(id).orElse(null);
	}

	@PostMapping
	public Processus createProcessus(@RequestBody Processus processus) {
		return processusDao.save(processus);
	}

	@PutMapping("/{id}")
	public Processus updateProcessus(@PathVariable Long id, @RequestBody Processus processus) {
		processus.setId(id);
		return processusDao.save(processus);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProcessus(@PathVariable Long id) {
		processusDao.deleteById(id);
		return ResponseEntity.ok().build();
	}
//	 @GetMapping("/listCnvab")
//	 public ResponseEntity<?> listCnvab() {
//	     try {
//	         List<Cnvab> listCnvab = cda.findAll();
//	         return ResponseEntity.ok().body(listCnvab);
//	     } catch (Exception e) {
//	         return ResponseEntity.badRequest().body("Une erreur est survenue lors de la récupération de la liste des Cnvab.");
//	     }
//	 }

}