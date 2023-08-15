package com.nnr.gestionDeTachesCollaboratif.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nnr.gestionDeTachesCollaboratif.exception.GestionDeTachesCollaboratifException;
import com.nnr.gestionDeTachesCollaboratif.model.AppRoles;
import com.nnr.gestionDeTachesCollaboratif.model.Users;
import com.nnr.gestionDeTachesCollaboratif.repository.RolesRepository;
import com.nnr.gestionDeTachesCollaboratif.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Transactional
@Slf4j
public class ImplementInterfaceUsers implements InterfaceUsers {
	/**
	 * @author Roumuald
	 */

	private UsersRepository userRepository;
	private RolesRepository rolesRepository;
	
	@Autowired
	public ImplementInterfaceUsers(UsersRepository userRepository, RolesRepository rolesRepository) {
		super();
		this.userRepository = userRepository;
		this.rolesRepository = rolesRepository;
	}

	@Override
	public void registerUser(Users user) {
		 userRepository.save(user);	
	}
	
	@Override
	public AppRoles newRoles(AppRoles roles) {
		AppRoles role = rolesRepository.save(roles);
		
		return role;
	}

	@Override
	public List<Users> getUser() {
		List<Users> getUsers = userRepository.findAll();
		if(getUsers.isEmpty()) {
			return getUsers;
		}else {
			log.error("Aucun utilisateur disponible en base de donnees");
			throw new GestionDeTachesCollaboratifException("Aucun utilisateur disponible en base de donnees");
		}	
	}

	@Override
	public void addRolesToUser(String email, String roleName) {
		Users user = userRepository.findByEmail(email);
		AppRoles roles = rolesRepository.findByRoleName(roleName);
		if(user!=null&&roles!=null) {
			user.getRoles().add(roles);
		}else {
			log.error("Imposible d'ajouter le role");
			throw new GestionDeTachesCollaboratifException("Imposible d'ajouter le role");
		}	
	}
}
