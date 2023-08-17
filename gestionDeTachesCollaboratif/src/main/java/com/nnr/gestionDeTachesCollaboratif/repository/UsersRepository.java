package com.nnr.gestionDeTachesCollaboratif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnr.gestionDeTachesCollaboratif.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	//public Users findByEmail(String email);
	
	public Users findByUsername(String username);

}
