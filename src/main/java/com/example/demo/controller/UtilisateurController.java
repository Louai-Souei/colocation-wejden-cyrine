
//CONTROLLER
package com.example.demo.controller;

import com.example.demo.security.User;
import com.example.demo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

@Autowired
private UtilisateurService utilisateurService;

// Create a new utilisateur
@PostMapping
public ResponseEntity<User> createUtilisateur(@RequestBody User utilisateur) {
   User createdUtilisateur = utilisateurService.createUtilisateur(utilisateur);
   return ResponseEntity.ok(createdUtilisateur);
}

// Get all utilisateurs
@GetMapping
public ResponseEntity<List<User>> getAllUtilisateurs() {
   List<User> utilisateurs = utilisateurService.getAllUtilisateurs();
   return ResponseEntity.ok(utilisateurs);
}

// Get utilisateur by ID
@GetMapping("/{id}")
public ResponseEntity<User> getUtilisateurById(@PathVariable Long id) {
   Optional<User> utilisateur = utilisateurService.getUserById(id);
   return utilisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}

// Update utilisateur
@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User UserDetails) {
   Optional<User> updatedUtilisateur = utilisateurService.updateUser(id, UserDetails);
   return updatedUtilisateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}

// Delete utilisateur
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
   boolean isDeleted = utilisateurService.deleteUtilisateur(id);
   if (isDeleted) {
       return ResponseEntity.noContent().build();
   } else {
       return ResponseEntity.notFound().build();
   }
}
}
