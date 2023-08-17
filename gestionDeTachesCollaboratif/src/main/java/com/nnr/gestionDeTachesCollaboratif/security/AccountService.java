package com.nnr.gestionDeTachesCollaboratif.security;

import java.util.List;

import com.nnr.gestionDeTachesCollaboratif.model.AppRoles;
import com.nnr.gestionDeTachesCollaboratif.model.Users;

public interface AccountService {
	
	public Users addNewUser(Users user, String confimPassword);
	
	public AppRoles addNewRole(AppRoles role);
	
	public void addRoleToUser(String email, String roleName);
	
	public void moveRoleToUser(String email, String roleName);
	
	public Users loaderUserByEmailUser(String email);
	
	public List<Users> getAllUsers();

}
