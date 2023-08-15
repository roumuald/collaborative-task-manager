package com.nnr.gestionDeTachesCollaboratif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.gestionDeTachesCollaboratif.model.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long>{

}
