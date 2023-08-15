package com.nnr.gestionDeTachesCollaboratif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.gestionDeTachesCollaboratif.model.Files;

@Repository
public interface FilesRepository extends JpaRepository<Files, Long>{

}
