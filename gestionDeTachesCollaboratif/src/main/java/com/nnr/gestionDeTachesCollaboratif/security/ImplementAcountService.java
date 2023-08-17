package com.nnr.gestionDeTachesCollaboratif.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nnr.gestionDeTachesCollaboratif.exception.GestionDeTachesCollaboratifException;
import com.nnr.gestionDeTachesCollaboratif.model.AppRoles;
import com.nnr.gestionDeTachesCollaboratif.model.Users;
import com.nnr.gestionDeTachesCollaboratif.repository.RolesRepository;
import com.nnr.gestionDeTachesCollaboratif.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ImplementAcountService implements AccountService{
	
	private UsersRepository usersRepository;
	private RolesRepository rolesRepository;
	
	public ImplementAcountService(UsersRepository usersRepository, RolesRepository rolesRepository) {
		super();
		this.usersRepository = usersRepository;
		this.rolesRepository = rolesRepository;
	}

	@Override
	public Users addNewUser(Users user, String confimPassword) {
		//Users userExiste = usersRepository.findByEmail(user.getUsername());
		Users userExiste = usersRepository.findByUsername(user.getUsername());
		if(userExiste!=null) throw new GestionDeTachesCollaboratifException("L'adresse email"+""+userExiste.getUsername()+""+"existe deja !!!");
		if(!(user.getPassword().equals(confimPassword))) throw new GestionDeTachesCollaboratifException("Mot de passe different !!!");
		//user.setPassword(passwordEncoder().encode(user.getPassword()));
		userExiste= usersRepository.save(user);
		return userExiste;
	}

	@Override
	public AppRoles addNewRole(AppRoles role) {
		AppRoles roleExist=rolesRepository.findByRoleName(role.getRoleName());
		if(roleExist!=null) throw new GestionDeTachesCollaboratifException("le nom "+""+roleExist.getRoleName()+""+"existe deja !!!");
		roleExist=rolesRepository.save(role);
		return roleExist;
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		//Users user = usersRepository.findByEmail(email);
		Users user = usersRepository.findByUsername(username);
		AppRoles role =  rolesRepository.findByRoleName(roleName);
		if(user==null&&role==null) throw new GestionDeTachesCollaboratifException("L'utilisateur ou le role n'existe pas");
		user.getRoles().add(role);
		
	}

	@Override
	public void moveRoleToUser(String username, String roleName) {
		//Users user = usersRepository.findByEmail(email);
		Users user = usersRepository.findByUsername(username);
		AppRoles role =  rolesRepository.findByRoleName(roleName);
		if(user==null&&role==null) throw new GestionDeTachesCollaboratifException("L'utilisateur ou le role n'existe pas");
		user.getRoles().remove(role);	
	}

	@Override
	public Users loaderUserByEmailUser(String username) {
		//Users user = usersRepository.findByEmail(email);
		Users user = usersRepository.findByUsername(username);
		if(user==null) throw new GestionDeTachesCollaboratifException("pas d'utilisateur avec l'email"+""+ username);
		return user;
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> users = usersRepository.findAll();
		if(users.isEmpty()) throw new GestionDeTachesCollaboratifException("Aucun utilisateur en base de donnees");
		return users;
	}
	
	//@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
