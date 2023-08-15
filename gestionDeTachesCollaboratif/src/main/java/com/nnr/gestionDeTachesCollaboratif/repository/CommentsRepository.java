package com.nnr.gestionDeTachesCollaboratif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.gestionDeTachesCollaboratif.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>{

}
