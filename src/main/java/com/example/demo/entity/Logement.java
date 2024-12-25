package com.example.demo.entity;

import com.example.demo.security.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
	
	
	

}
