package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.entity.Disponibilite;
import com.example.demo.service.DisponibiliteService;

@RestController
@RequestMapping("/api/disponibilites")
public class DisponibiliteController {
	@Autowired
    private DisponibiliteService disponibiliteService;

    // Créer une nouvelle disponibilité
    @PostMapping
    public ResponseEntity<Disponibilite> createDisponibilite(@RequestBody Disponibilite disponibilite) {
        Disponibilite createdDisponibilite = disponibiliteService.createDisponibilite(disponibilite);
        return new ResponseEntity<>(createdDisponibilite, HttpStatus.CREATED);
    }

    // Obtenir toutes les disponibilités
    @GetMapping
    public ResponseEntity<List<Disponibilite>> getAllDisponibilites() {
        List<Disponibilite> disponibilites = disponibiliteService.getAllDisponibilites();
        return new ResponseEntity<>(disponibilites, HttpStatus.OK);
    }

    // Obtenir une disponibilité par ID
    @GetMapping("/{id}")
    public ResponseEntity<Disponibilite> getDisponibiliteById(@PathVariable Long id) {
        Optional<Disponibilite> disponibilite = disponibiliteService.getDisponibiliteById(id);
        return disponibilite.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Mettre à jour une disponibilité
    @PutMapping("/{id}")
    public ResponseEntity<Disponibilite> updateDisponibilite(@PathVariable Long id, @RequestBody Disponibilite disponibilite) {
        Disponibilite updatedDisponibilite = disponibiliteService.updateDisponibilite(id, disponibilite);
        return new ResponseEntity<>(updatedDisponibilite, HttpStatus.OK);
    }

    // Supprimer une disponibilité
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisponibilite(@PathVariable Long id) {
        disponibiliteService.deleteDisponibilite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	

}
