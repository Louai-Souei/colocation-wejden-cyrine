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
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double montant;
    private String description;

    @ManyToOne
    @JoinColumn(name = "colocation_id")
    private Colocation colocation;

    @ManyToMany
    @JoinTable(
        name = "depense_utilisateur",
        joinColumns = @JoinColumn(name = "depense_id"),
        inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    private List<User> payeurs;

}
