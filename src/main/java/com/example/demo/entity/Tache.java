package com.example.demo.entity;

import com.example.demo.security.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tache {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "colocation_id")
    private Colocation colocation;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

}
