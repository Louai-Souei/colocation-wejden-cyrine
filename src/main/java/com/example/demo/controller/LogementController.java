package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Logement;
import com.example.demo.service.LogementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/logements")
public class LogementController {
	@Autowired
    private LogementService logementService;

    // Créer un nouveau logement
    @PostMapping
    public ResponseEntity<Logement> createLogement(@RequestBody Logement logement) {
        Logement createdLogement = logementService.createLogement(logement);
        return new ResponseEntity<>(createdLogement, HttpStatus.CREATED);
    }

    // Obtenir tous les logements
    @GetMapping
    public ResponseEntity<List<Logement>> getAllLogements() {
        List<Logement> logements = logementService.getAllLogements();
        return new ResponseEntity<>(logements, HttpStatus.OK);
    }

    // Obtenir un logement par ID
    @GetMapping("/{id}")
    public ResponseEntity<Logement> getLogementById(@PathVariable Long id) {
        Optional<Logement> logement = logementService.getLogementById(id);
        return logement.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Mettre à jour un logement
    @PutMapping("/{id}")
    public ResponseEntity<Logement> updateLogement(@PathVariable Long id, @RequestBody Logement logement) {
        Logement updatedLogement = logementService.updateLogement(id, logement);
        return new ResponseEntity<>(updatedLogement, HttpStatus.OK);
    }

    // Supprimer un logement
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogement(@PathVariable Long id) {
        logementService.deleteLogement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
