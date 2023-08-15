package com.nnr.gestionDeTachesCollaboratif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.gestionDeTachesCollaboratif.model.AttributionTasks;

@Repository
public interface AttributionTasksRepository extends JpaRepository<AttributionTasks, Long>{

}
