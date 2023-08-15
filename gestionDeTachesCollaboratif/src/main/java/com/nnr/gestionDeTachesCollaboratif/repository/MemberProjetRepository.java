package com.nnr.gestionDeTachesCollaboratif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.gestionDeTachesCollaboratif.model.MemberProjet;

@Repository
public interface MemberProjetRepository extends JpaRepository<MemberProjet, Long>{

}
