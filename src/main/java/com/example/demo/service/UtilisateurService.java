package com.example.demo.service;

import com.example.demo.security.User;
import com.example.demo.security.config.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UserRepository userRepository;

    // Create a new utilisateur
    public User createUtilisateur(User user) {
        return userRepository.save(user);
    }

    // Get all utilisateurs
    public List<User> getAllUtilisateurs() {
        return userRepository.findAll();
    }

    // Get utilisateur by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update utilisateur
    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
        	user.setNom(userDetails.getNom());
        	user.setPrenom(userDetails.getPrenom());
        	user.setEmail(userDetails.getEmail());
        	user.setTelephone(userDetails.getTelephone());
        	user.setPassword(userDetails.getPassword());
        	user.setRole(userDetails.getRole());
        	user.setAdresse(userDetails.getAdresse());
        	user.setBudget(userDetails.getBudget());
        	user.setPreferences(userDetails.getPreferences());
            return userRepository.save(user);
        });
    }

    // Delete utilisateur
    public boolean deleteUtilisateur(Long id) {
        if (userRepository.existsById(id)) {
        	userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
