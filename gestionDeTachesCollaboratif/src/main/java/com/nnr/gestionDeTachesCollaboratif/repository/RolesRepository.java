package com.nnr.gestionDeTachesCollaboratif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnr.gestionDeTachesCollaboratif.model.AppRoles;

public interface RolesRepository extends JpaRepository<AppRoles, Long>{
	
	public AppRoles findByRoleName(String roleName);

}
