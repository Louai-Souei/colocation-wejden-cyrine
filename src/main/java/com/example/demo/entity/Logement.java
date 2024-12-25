package com.example.demo.entity;

import java.util.List;

import com.example.demo.security.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String adresse;
	
	@ElementCollection
	private List<String> photos;
	
	private Double prix;
	private String description;
	
	@ElementCollection
	private List<String> equipements;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "disponibilite_id")
	private Disponibilite disponibilite;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private User utilisateur;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
