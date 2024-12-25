package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Disponibilite;
import com.example.demo.repository.DisponibiliteRepository;

@Service
public class DisponibiliteService {
	
	@Autowired
	private DisponibiliteRepository disponibiliteRepository;
	
	 // Cree une nouvelle disp
	public Disponibilite createDisponibilite(Disponibilite disponibilite) {
		return disponibiliteRepository.save(disponibilite);
	}
	// Obtenir une liste de toutes les disponibilités
    public List<Disponibilite> getAllDisponibilites() {
        return disponibiliteRepository.findAll();
    }

    // Obtenir une disponibilité par son ID
    public Optional<Disponibilite> getDisponibiliteById(Long id) {
        return disponibiliteRepository.findById(id);
    }

    // Mettre à jour une disponibilité
    public Disponibilite updateDisponibilite(Long id, Disponibilite disponibilite) {
        disponibilite.setId(id);
        return disponibiliteRepository.save(disponibilite);
    }

    // Supprimer une disponibilité
    public void deleteDisponibilite(Long id) {
        disponibiliteRepository.deleteById(id);
    }
}
