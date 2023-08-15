package com.nnr.gestionDeTachesCollaboratif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.gestionDeTachesCollaboratif.model.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>{

}
