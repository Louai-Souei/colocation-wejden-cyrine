package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Logement;

public interface LogementRepository extends JpaRepository<Logement, Long> {

}
