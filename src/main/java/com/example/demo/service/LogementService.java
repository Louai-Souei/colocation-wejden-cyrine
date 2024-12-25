package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Logement;
import com.example.demo.repository.LogementRepository;

@Service
public class LogementService {
	
	@Autowired
    private LogementRepository logementRepository;

    // Créer un nouveau logement
    public Logement createLogement(Logement logement) {
        return logementRepository.save(logement);
    }

    // Obtenir une liste de tous les logements
    public List<Logement> getAllLogements() {
        return logementRepository.findAll();
    }

    // Obtenir un logement par son ID
    public Optional<Logement> getLogementById(Long id) {
        return logementRepository.findById(id);
    }

    // Mettre à jour un logement
    public Logement updateLogement(Long id, Logement logement) {
        logement.setId(id);
        return logementRepository.save(logement);
    }

    // Supprimer un logement
    public void deleteLogement(Long id) {
        logementRepository.deleteById(id);
    }

}
