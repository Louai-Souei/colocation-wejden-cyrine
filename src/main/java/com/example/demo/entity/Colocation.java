package com.example.demo.entity;

import java.util.List;

import com.example.demo.security.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinTable(
		        name = "colocation_utilisateur",
		        joinColumns = @JoinColumn(name = "colocation_id"),
		        inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
		    )
	private List<User> colocataires;
	
	@OneToMany(mappedBy = "colocation")
    private List<Tache> taches;

    @OneToMany(mappedBy = "colocation")
    private List<Depense> depenses;

    @OneToMany(mappedBy = "colocation")
    private List<Evenement> calendrier;
	
	
}
